package org.ljy.enums;

/**
 * 订单状态枚举类
 * @author 廖俊瑶
 * 2017年1月15日 15:45:24
 */
public enum OrderStatement {
	NOTPAYED("未付款"),PAYED("已付款");
	private String statement;

	OrderStatement(String statement) {
		this.statement = statement;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
	
}
