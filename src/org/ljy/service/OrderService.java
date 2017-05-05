package org.ljy.service;

import org.ljy.common.Page;
import org.ljy.domain.Order;
import org.ljy.domain.OrderExample;

import java.util.List;

public interface OrderService {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    List<Order> selectByExampleByPage(OrderExample example, Page page);

    Order selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(Order record, OrderExample example);

    int updateByExample(Order record, OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
