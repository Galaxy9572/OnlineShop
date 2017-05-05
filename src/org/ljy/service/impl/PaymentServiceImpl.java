package org.ljy.service.impl;

import org.ljy.common.Page;
import org.ljy.dao.PaymentMapper;
import org.ljy.domain.Payment;
import org.ljy.domain.PaymentExample;
import org.ljy.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentMapper paymentMapper;

	@Override
	public long countByExample(PaymentExample example) {
		return paymentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(PaymentExample example) {
		return paymentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long paymentId) {
		return paymentMapper.deleteByPrimaryKey(paymentId);
	}

	@Override
	public int insert(Payment record) {
		return paymentMapper.insert(record);
	}

	@Override
	public int insertSelective(Payment record) {
		return paymentMapper.insertSelective(record);
	}

	@Override
	public List<Payment> selectByExample(PaymentExample example) {
		return paymentMapper.selectByExample(example);
	}

	@Override
	public List<Payment> selectByExampleByPage(PaymentExample example, Page page) {
		return paymentMapper.selectByExampleByPage(example,page);
	}

	@Override
	public Payment selectByPrimaryKey(Long paymentId) {
		return paymentMapper.selectByPrimaryKey(paymentId);
	}

	@Override
	public int updateByExampleSelective(Payment record, PaymentExample example) {
		return paymentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Payment record, PaymentExample example) {
		return paymentMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Payment record) {
		return paymentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Payment record) {
		return paymentMapper.updateByPrimaryKey(record);
	}

}
