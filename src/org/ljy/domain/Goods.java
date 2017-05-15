package org.ljy.domain;

import java.util.Date;

public class Goods {
    private Long goodsId;

    private Long shopId;

    private String goodsName;

    private Integer goodsType;

    private Double price;

    private Double discount;

    private Double rank;

    private Integer statement;

    private Date createTime;

    private Date modifyTime;

    private byte[] image;

    public Goods(Long goodsId, Long shopId, String goodsName, Integer goodsType, Double price, Double discount, Double rank, Integer statement, Date createTime, Date modifyTime, byte[] image) {
        this.goodsId = goodsId;
        this.shopId = shopId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.price = price;
        this.discount = discount;
        this.rank = rank;
        this.statement = statement;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.image = image;
    }

    public Goods() {
        super();
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}