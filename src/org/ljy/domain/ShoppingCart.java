package org.ljy.domain;

import java.util.Date;

public class ShoppingCart {
    private Long cartId;

    private Long userId;

    private String goodsId;

    private Date createTime;

    private Date modifyTime;

    public ShoppingCart(Long cartId, Long userId, String goodsId, Date createTime, Date modifyTime) {
        this.cartId = cartId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public ShoppingCart() {
        super();
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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