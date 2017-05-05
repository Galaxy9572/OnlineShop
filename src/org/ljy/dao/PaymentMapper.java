package org.ljy.dao;

import org.apache.ibatis.annotations.Param;
import org.ljy.common.Page;
import org.ljy.domain.Payment;
import org.ljy.domain.PaymentExample;

import java.util.List;

public interface PaymentMapper {

	long countByExample(PaymentExample example);

	int deleteByExample(PaymentExample example);

	int deleteByPrimaryKey(Long paymentId);

	int insert(Payment record);

	int insertSelective(Payment record);

	List<Payment> selectByExample(PaymentExample example);

	List<Payment> selectByExampleByPage(@Param("example") PaymentExample example, @Param("page")Page page);

	Payment selectByPrimaryKey(Long paymentId);

	int updateByExampleSelective(@Param("record") Payment record, @Param("example") PaymentExample example);

	int updateByExample(@Param("record") Payment record, @Param("example") PaymentExample example);

	int updateByPrimaryKeySelective(Payment record);

	int updateByPrimaryKey(Payment record);
}