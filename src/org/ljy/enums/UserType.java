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
	private int userType;
	private String typeName;

	UserType(int userType,String typeName) {
		this.userType = userType;
		this.typeName = typeName;
	}

	public int key() {
	    return this.userType;
	}
	public String value(){return this.typeName;}
}
