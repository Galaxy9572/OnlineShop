package org.ljy.service;

import org.ljy.common.Page;
import org.ljy.domain.Payment;
import org.ljy.domain.PaymentExample;

import java.util.List;

public interface PaymentService {
    long countByExample(PaymentExample example);

    int deleteByExample(PaymentExample example);

    int deleteByPrimaryKey(Long paymentId);

    int insert(Payment record);

    int insertSelective(Payment record);

    List<Payment> selectByExample(PaymentExample example);

    List<Payment> selectByExampleByPage(PaymentExample example, Page page);

    Payment selectByPrimaryKey(Long paymentId);

    int updateByExampleSelective(Payment record, PaymentExample example);

    int updateByExample(Payment record, PaymentExample example);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}
