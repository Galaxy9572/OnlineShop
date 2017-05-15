package org.ljy.enums;

public enum UserType {
	/**
	 * 买家
	 */
	BUYER(1,"买家"),
	/**
	 * 卖家
	 */
	SELLER(2,"卖家"),
    /**
     * 管理员
     */
	ADMIN(3,"管理员");
	private int key;
	private String value;

	UserType(int userType,String typeName) {
		this.key = userType;
		this.value = typeName;
	}

	public int key() {
	    return this.key;
	}
	public String value(){return this.value;}
}
