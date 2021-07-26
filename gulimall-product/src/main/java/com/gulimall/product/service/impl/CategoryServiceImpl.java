package com.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gulimall.common.utils.PageUtils;
import com.gulimall.common.utils.Query;

import com.gulimall.product.dao.CategoryDao;
import com.gulimall.product.entity.CategoryEntity;
import com.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> ListWithTree() {
        List<CategoryEntity> categoryEntities = this.list(null);

        List<CategoryEntity> collect = categoryEntities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0L)
                .map(categoryEntity -> {
                    categoryEntity.setChildren(getChildren(categoryEntity,categoryEntities));
                    return categoryEntity;})
                .sorted(Comparator.comparing(CategoryEntity::getSort,Comparator.nullsFirst(Integer::compareTo)))
                .collect(Collectors.toList());

        return collect;
    }

    /**
     * 使用递归遍历所有子菜单
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {

        List<CategoryEntity> collect = all.stream().filter(categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId()))
                .map(categoryEntity -> {
                    categoryEntity.setChildren(getChildren(categoryEntity, all));
                    return categoryEntity;
                })
                .sorted(Comparator.comparing(CategoryEntity::getSort,Comparator.nullsFirst(Integer::compareTo)))
                .collect(Collectors.toList());
        return collect;
    }

}