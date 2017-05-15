package org.ljy.domain;

import java.util.Date;

public class UserMessage {
    private Long messageId;

    private Long userId;

    private Long fromUserId;

    private String context;

    private Integer statement;

    private Date createTime;

    private Date modifyTime;

    public UserMessage(Long messageId, Long userId, Long fromUserId, String context, Integer statement, Date createTime, Date modifyTime) {
        this.messageId = messageId;
        this.userId = userId;
        this.fromUserId = fromUserId;
        this.context = context;
        this.statement = statement;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public UserMessage() {
        super();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
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
}