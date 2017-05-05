package org.ljy.domain;

import java.util.Date;

public class Shop {

	private Long shopId;
	private Long userId;
	private String shopName;
	private String location;
	private Double rank;
	private Integer statement;
	private Date createTime;
	private Date modifyTime;
	private byte[] portrait;

	public Shop(Long shopId, Long userId, String shopName, String location, Double rank, Integer statement,
			Date createTime, Date modifyTime, byte[] portrait) {
		this.shopId = shopId;
		this.userId = userId;
		this.shopName = shopName;
		this.location = location;
		this.rank = rank;
		this.statement = statement;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.portrait = portrait;
	}

	public Shop() {
		super();
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName == null ? null : shopName.trim();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location == null ? null : location.trim();
	}

	public Double getRank() {
		return rank;
	}

	public void setRank(Double rank) {
		this.rank = rank;
	}

	public Integer getStatement() {
		return statement;
	}

	public void setStatement(Integer statement) {
		this.statement = statement;
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

	public byte[] getPortrait() {
		return portrait;
	}

	public void setPortrait(byte[] portrait) {
		this.portrait = portrait;
	}
}