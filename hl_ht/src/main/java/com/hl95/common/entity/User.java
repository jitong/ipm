package com.hl95.common.entity;

import java.io.Serializable;

/**
 * 
 * 用户信息
 * @author chenYan
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	//用户ID
	private Integer userId;
	//用户名称
	private String userName;
	//用户余额
	private double balance;
	//短信单价
	private double price;
	//发送记录推送地址
	private String sendUrl;
	//是否启用
	private String userYn;
	//是否删除
	private String delYn;
	//模板信息  格式	模板1，模板2,模板3
	private String smsModel;
	

	public String getSmsModel() {
		return smsModel;
	}

	public void setSmsModel(String smsModel) {
		this.smsModel = smsModel;
	}

	public String getSendUrl() {
		return sendUrl;
	}

	public void setSendUrl(String sendUrl) {
		this.sendUrl = sendUrl;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUserYn() {
		return userYn;
	}

	public void setUserYn(String userYn) {
		this.userYn = userYn;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	

}
