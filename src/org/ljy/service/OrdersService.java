package org.ljy.service;

import org.ljy.common.PagedResult;
import org.ljy.domain.Orders;
import org.ljy.domain.OrdersExample;

public interface OrdersService {
    long countByExample(OrdersExample example);

    boolean addOrder(Orders order);

    boolean deleteOrderByOrderId(Long orderId);

    boolean updateOrder(Orders order);

    PagedResult queryOrdersByPage(String queryType,String userId,String statement,Integer pageNo, Integer pageSize);

}
