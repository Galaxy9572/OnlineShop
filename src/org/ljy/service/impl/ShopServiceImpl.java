package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.ShopMapper;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;
import org.ljy.service.ShopService;
import org.ljy.util.BeanUtil;
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
	public PagedResult selectByExampleWithBLOBsByPage(ShopExample example, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);
		return BeanUtil.toPagedResult(shopMapper.selectByExampleWithBLOBs(example));
	}

	@Override
	public PagedResult selectByExampleByPage(ShopExample example, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);
		return BeanUtil.toPagedResult(shopMapper.selectByExample(example));
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
