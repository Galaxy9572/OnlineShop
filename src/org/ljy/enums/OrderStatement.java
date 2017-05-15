package org.ljy.enums;

/**
 * 订单状态枚举类
 * @author 廖俊瑶
 * 2017年1月15日 15:45:24
 */
public enum OrderStatement {
	NOTPAYED(1,"未付款"),
	PAYED(2,"已付款"),
	NOT_SEND(3,"待发货"),
	DELIVERY(4,"在途中"),
	RECEIVED(5,"已收货");

	private int key;
	private String value;

	OrderStatement(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int key() {
		return key;
	}

	public String value() {
		return value;
	}
}
