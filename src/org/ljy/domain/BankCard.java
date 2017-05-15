package org.ljy.domain;

import java.util.Date;

public class BankCard {
    private Long bankCardId;

    private Long userId;

    private String bankName;

    private Date createTime;

    private Date modifyTime;

    public BankCard(Long bankCardId, Long userId, String bankName, Date createTime, Date modifyTime) {
        this.bankCardId = bankCardId;
        this.userId = userId;
        this.bankName = bankName;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public BankCard() {
        super();
    }

    public Long getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(Long bankCardId) {
        this.bankCardId = bankCardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
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