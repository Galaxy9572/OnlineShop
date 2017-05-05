package org.ljy.enums;

/**
 * Created by ljy56 on 2017/4/15.
 */
public enum GoodsStatement {
    NORMAL(1,"未读"),
    ILLEGAL(2,"违规"),
    DELETED(0,"删除");

    private int statement;
    private String value;

    GoodsStatement(int statement, String value) {
        this.statement = statement;
        this.value = value;
    }

    public int getStatement() {
        return statement;
    }

    public String getValue() {
        return value;
    }
}
