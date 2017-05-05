package org.ljy.domain;

import java.util.Date;

public class UserCollection {

	private Long collectionId;
	private Long userId;
	private String shopId;
	private String goodsId;
	private Date createTime;
	private Date modifyTime;

	public UserCollection(Long collectionId, Long userId, String shopId, String goodsId, Date createTime,
			Date modifyTime) {
		this.collectionId = collectionId;
		this.userId = userId;
		this.shopId = shopId;
		this.goodsId = goodsId;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
	}

	public UserCollection() {
		super();
	}

	public Long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId == null ? null : shopId.trim();
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId == null ? null : goodsId.trim();
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