package com.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gulimall.common.utils.PageUtils;
import com.gulimall.product.entity.AttrEntity;
import com.gulimall.product.vo.AttrRespVo;
import com.gulimall.product.vo.AttrVo;

import java.util.Map;

/**
 * 商品属性
 *
 * @author ljf
 * @email ljf@gmail.com
 * @date 2021-07-09 14:20:12
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId,String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);
}

