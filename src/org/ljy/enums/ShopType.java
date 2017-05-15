package org.ljy.enums;

/**
 * Created by ljy56 on 2017/4/4.
 */
public enum ShopType {
    CLOTHES(1,"服饰"),
    FOODS(2,"食品"),
    ELECTRIC(3,"电器"),
    DIGITAL(4,"数码"),
    SPORTS(5,"运动"),
    OUTDOOR(6,"户外"),
    HEALTH(7,"健康");

    private int key;
    private String value;

    ShopType(int typeInt, String typeName) {
        this.key = typeInt;
        this.value = typeName;
    }

    public int key() {return this.key;}

    public String value() {
        return this.value;
    }
}
