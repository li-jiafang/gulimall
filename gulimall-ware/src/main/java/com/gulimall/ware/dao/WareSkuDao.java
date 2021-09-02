package com.gulimall.ware.dao;

import com.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author ljf
 * @email ljf@gmail.com
 * @date 2021-07-09 16:11:14
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {

    void addStock(Long skuId, Long wareId, Integer skuNum);
}
