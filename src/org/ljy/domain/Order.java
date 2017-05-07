package org.ljy.domain;

import java.util.Date;

public class Order{

	private Long orderId;
	private Long userId;
	private Long goodsId;
	private Integer statement;
	private Date createDate;
	private Date modifyDate;

	public Order(Long orderId, Long userId, Long goodsId, Integer statement, Date createDate, Date modifyDate) {
		this.orderId = orderId;
		this.userId = userId;
		this.goodsId = goodsId;
		this.statement = statement;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public Order() {
		super();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getStatement() {
		return statement;
	}

	public void setStatement(Integer statement) {
		this.statement = statement;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}