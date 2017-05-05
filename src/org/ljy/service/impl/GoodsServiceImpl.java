package org.ljy.service.impl;

import org.ljy.common.Page;
import org.ljy.dao.GoodsMapper;
import org.ljy.domain.Goods;
import org.ljy.domain.GoodsExample;
import org.ljy.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Resource
	private GoodsMapper goodsMapper;

	@Override
	public long countByExample(GoodsExample example) {
		return goodsMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(GoodsExample example) {
		return goodsMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long goodsId) {
		return goodsMapper.deleteByPrimaryKey(goodsId);
	}

	@Override
	public int insert(Goods record) {
		return goodsMapper.insert(record);
	}

	@Override
	public int insertSelective(Goods record) {
		return goodsMapper.insertSelective(record);
	}

	@Override
	public List<Goods> selectByExampleWithBLOBs(GoodsExample example) {
		return goodsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<Goods> selectByExample(GoodsExample example) {
		return goodsMapper.selectByExample(example);
	}

	@Override
	public List<Goods> selectByExampleWithBLOBsByPage(GoodsExample example, Page page) {
		return goodsMapper.selectByExampleWithBLOBsByPage(example, page);
	}

	@Override
	public List<Goods> selectByExampleByPage(GoodsExample example, Page page) {
		return goodsMapper.selectByExampleByPage(example, page);
	}

	@Override
	public Goods selectByPrimaryKey(Long goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}

	@Override
	public int updateByExampleSelective(Goods record, GoodsExample example) {
		return goodsMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExampleWithBLOBs(Goods record, GoodsExample example) {
		return goodsMapper.updateByExampleWithBLOBs(record, example);
	}

	@Override
	public int updateByExample(Goods record, GoodsExample example) {
		return goodsMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Goods record) {
		return goodsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Goods record) {
		return goodsMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(Goods record) {
		return goodsMapper.updateByPrimaryKey(record);
	}

}
