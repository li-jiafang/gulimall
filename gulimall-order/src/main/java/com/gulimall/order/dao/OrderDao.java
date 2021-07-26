package com.gulimall.order.dao;

import com.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ljf
 * @email ljf@gmail.com
 * @date 2021-07-09 16:05:44
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
