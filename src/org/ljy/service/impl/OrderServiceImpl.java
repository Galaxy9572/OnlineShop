package org.ljy.service.impl;

import org.ljy.common.Page;
import org.ljy.dao.OrderMapper;
import org.ljy.domain.Order;
import org.ljy.domain.OrderExample;
import org.ljy.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderMapper orderMapper;

	@Override
	public long countByExample(OrderExample example) {
		return orderMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(OrderExample example) {
		return orderMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long key) {
		return orderMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(Order record) {
		return orderMapper.insert(record);
	}

	@Override
	public int insertSelective(Order record) {
		return orderMapper.insertSelective(record);
	}

	@Override
	public List<Order> selectByExample(OrderExample example) {
		return orderMapper.selectByExample(example);
	}

	@Override
	public List<Order> selectByExampleByPage(OrderExample example, Page page) {
		return orderMapper.selectByExampleByPage(example, page);
	}

	@Override
	public Order selectByPrimaryKey(Long key) {
		return orderMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByExampleSelective(Order record, OrderExample example) {
		return orderMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Order record, OrderExample example) {
		return orderMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Order record) {
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Order record) {
		return orderMapper.updateByPrimaryKey(record);
	}
}
