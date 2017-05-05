package org.ljy.service.impl;

import org.ljy.dao.ShoppingCartMapper;
import org.ljy.domain.ShoppingCart;
import org.ljy.domain.ShoppingCartExample;
import org.ljy.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("shoppingService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Resource
	private ShoppingCartMapper shoppingCartMapper;

	@Override
	public long countByExample(ShoppingCartExample example) {
		return shoppingCartMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ShoppingCartExample example) {
		return shoppingCartMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long cartId) {
		return shoppingCartMapper.deleteByPrimaryKey(cartId);
	}

	@Override
	public int insert(ShoppingCart record) {
		return shoppingCartMapper.insert(record);
	}

	@Override
	public int insertSelective(ShoppingCart record) {
		return shoppingCartMapper.insertSelective(record);
	}

	@Override
	public List<ShoppingCart> selectByExample(ShoppingCartExample example) {
		return shoppingCartMapper.selectByExample(example);
	}

	@Override
	public ShoppingCart selectByPrimaryKey(Long cartId) {
		return shoppingCartMapper.selectByPrimaryKey(cartId);
	}

	@Override
	public int updateByExampleSelective(ShoppingCart record, ShoppingCartExample example) {
		return shoppingCartMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(ShoppingCart record, ShoppingCartExample example) {
		return shoppingCartMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ShoppingCart record) {
		return shoppingCartMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ShoppingCart record) {
		return shoppingCartMapper.updateByPrimaryKey(record);
	}

}
