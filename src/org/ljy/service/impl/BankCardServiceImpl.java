package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.BankCardMapper;
import org.ljy.domain.BankCard;
import org.ljy.domain.BankCardExample;
import org.ljy.service.BankCardService;
import org.ljy.util.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("bankCardService")
public class BankCardServiceImpl implements BankCardService {
	@Resource
	private BankCardMapper bankCardMapper;

	@Override
	public long countByExample(BankCardExample example) {
		return bankCardMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(BankCardExample example) {
		return bankCardMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long bankCardId) {
		return bankCardMapper.deleteByPrimaryKey(bankCardId);
	}

	@Override
	public int insert(BankCard record) {
		return bankCardMapper.insert(record);
	}

	@Override
	public int insertSelective(BankCard record) {
		return bankCardMapper.insertSelective(record);
	}

	@Override
	public List<BankCard> selectByExample(BankCardExample example) {
		return bankCardMapper.selectByExample(example);
	}

	@Override
	public PagedResult selectByExampleByPage(BankCardExample example, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return BeanUtil.toPagedResult(bankCardMapper.selectByExample(example));
	}

	@Override
	public BankCard selectByPrimaryKey(Long bankCardId) {
		return bankCardMapper.selectByPrimaryKey(bankCardId);
	}

	@Override
	public int updateByExampleSelective(BankCard record, BankCardExample example) {
		return bankCardMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BankCard record, BankCardExample example) {
		return bankCardMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(BankCard record) {
		return bankCardMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BankCard record) {
		return bankCardMapper.updateByPrimaryKey(record);
	}

}
