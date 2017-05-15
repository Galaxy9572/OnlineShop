package org.ljy.enums;

/**
 * Created by ljy56 on 2017/4/15.
 */
public enum ShopStatement {
    NORMAL(1,"未读"),
    ILLEGAL(2,"违规"),
    CLOSED(0,"关闭");

    private int key;
    private String value;

    ShopStatement(int statement, String value) {
        this.key = statement;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
