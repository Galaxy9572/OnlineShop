package org.ljy.domain;

import java.util.Date;

public class UserCollection {
    private Long collectionId;

    private Long userId;

    private Long shopId;

    private Long goodsId;

    private Date createTime;

    private Date modifyTime;

    public UserCollection(Long collectionId, Long userId, Long shopId, Long goodsId, Date createTime, Date modifyTime) {
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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