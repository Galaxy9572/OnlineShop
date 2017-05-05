package org.ljy.dao;

import org.apache.ibatis.annotations.Param;
import org.ljy.common.Page;
import org.ljy.domain.Order;
import org.ljy.domain.OrderExample;

import java.util.List;

public interface OrderMapper {

	long countByExample(OrderExample example);

	int deleteByExample(OrderExample example);

	int deleteByPrimaryKey(Long orderId);

	int insert(Order record);

	int insertSelective(Order record);

	List<Order> selectByExample(OrderExample example);

	List<Order> selectByExampleByPage(@Param("example") OrderExample example, @Param("page")Page page);

	Order selectByPrimaryKey(Long orderId);

	int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

	int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);
}