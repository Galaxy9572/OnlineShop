package org.ljy.enums;

/**
 * 商品种类枚举类
 * 
 * @author 廖俊瑶 2017年1月14日 23:14:56
 */
public enum GoodsType {
	MANCLOTH(1,"男上衣"),
	MANPANT(2,"男裤"),
	MANSHOES(3,"男鞋"),
	WOMANCLOTH(4,"女上衣"),
	WOMANPANT(5,"女裤"),
	WOMANSHOES(6,"女鞋"),
	PC(7,"电脑"),
	PHONE(8,"手机"),
	BOOK(9,"书籍");
	private int goodsInt;
	private String goodsType;

	GoodsType(int goodsInt, String goodsType) {
		this.goodsInt = goodsInt;
		this.goodsType = goodsType;
	}

	public int key() {
		return this.goodsInt;
	}

	public String value() {
	    return this.goodsType;
	}

}