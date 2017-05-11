package org.ljy.domain;

import java.util.Date;

public class BankCard {
    private Long bankCardId;

    private String userId;

    private String bankName;

    private Long paymentId;

    private Date createTime;

    private Date modifyTime;

    public BankCard(Long bankCardId, String userId, String bankName, Long paymentId, Date createTime, Date modifyTime) {
        this.bankCardId = bankCardId;
        this.userId = userId;
        this.bankName = bankName;
        this.paymentId = paymentId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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