package org.ljy.service.impl;

import org.ljy.common.Page;
import org.ljy.dao.ShopMapper;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;
import org.ljy.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Resource
	private ShopMapper shopMapper;

	@Override
	public long countByExample(ShopExample example) {
		return shopMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ShopExample example) {
		return shopMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long shopId) {
		return shopMapper.deleteByPrimaryKey(shopId);
	}

	@Override
	public int insert(Shop record) {
		return shopMapper.insert(record);
	}

	@Override
	public int insertSelective(Shop record) {
		return shopMapper.insertSelective(record);
	}

	@Override
	public List<Shop> selectByExampleWithBLOBs(ShopExample example) {
		return shopMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<Shop> selectByExample(ShopExample example) {
		return shopMapper.selectByExample(example);
	}

	@Override
	public List<Shop> selectByExampleWithBLOBsByPage(ShopExample example, Page page) {
		return shopMapper.selectByExampleWithBLOBsByPage(example, page);
	}

	@Override
	public List<Shop> selectByExampleByPage(ShopExample example, Page page) {
		return shopMapper.selectByExampleByPage(example, page);
	}

	@Override
	public Shop selectByPrimaryKey(Long shopId) {
		return shopMapper.selectByPrimaryKey(shopId);
	}

	@Override
	public int updateByExampleSelective(Shop record, ShopExample example) {
		return shopMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExampleWithBLOBs(Shop record, ShopExample example) {
		return shopMapper.updateByExampleWithBLOBs(record, example);
	}

	@Override
	public int updateByExample(Shop record, ShopExample example) {
		return shopMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Shop record) {
		return shopMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Shop record) {
		return shopMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Shop record) {
		return shopMapper.updateByPrimaryKey(record);
	}

}
