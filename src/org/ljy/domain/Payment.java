package org.ljy.domain;

import java.util.Date;

public class Payment {

	private Long paymentId;
	private Long userId;
	private Long bankCardId;
	private Date createTime;
	private Date modifyTime;

	public Payment(Long paymentId, Long userId, Long bankCardId, Date createTime, Date modifyTime) {
		this.paymentId = paymentId;
		this.userId = userId;
		this.bankCardId = bankCardId;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public Payment() {
		super();
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBankCardId() {
		return bankCardId;
	}

	public void setBankCardId(Long bankCardId) {
		this.bankCardId = bankCardId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}