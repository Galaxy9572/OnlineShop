package org.ljy.enums;

/**
 * Created by ljy56 on 2017/4/15.
 */
public enum UserMessageStatement {
    READ(0,"已读"),
    NOTREAD(1,"未读");

    private int key;
    private String value;

    UserMessageStatement(int statement, String value) {
        this.key = statement;
        this.value = value;
    }

    public int key() {
        return key;
    }

    public String value() {
        return value;
    }
}
