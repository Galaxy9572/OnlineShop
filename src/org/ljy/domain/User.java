package org.ljy.domain;

import java.util.Date;

public class User{

	private Long userId;
	private String userName;
	private String password;
	private Integer userType;
	private String email;
	private String phone;
	private Integer statement;
	private Date regTime;
	private Date modifyTime;
	private byte[] portrait;

	public User(Long userId, String userName, String password, Integer userType, String email, String phone,
			Integer statement, Date regTime, Date modifyTime, byte[] portrait) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.phone = phone;
		this.statement = statement;
		this.regTime = regTime;
		this.modifyTime = modifyTime;
		this.portrait = portrait;
	}

	public User(Long userId, String userName, String password, Integer userType, String email, String phone,
				Integer statement, Date regTime, Date modifyTime) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.phone = phone;
		this.statement = statement;
		this.regTime = regTime;
		this.modifyTime = modifyTime;
	}

	public User() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public Integer getStatement() {
		return statement;
	}

	public void setStatement(Integer statement) {
		this.statement = statement;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public byte[] getPortrait() {
		return portrait;
	}

	public void setPortrait(byte[] portrait) {
		this.portrait = portrait;
	}
}