package com.gulimall.product.dao;

import com.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ljf
 * @email ljf@gmail.com
 * @date 2021-07-09 14:20:12
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
