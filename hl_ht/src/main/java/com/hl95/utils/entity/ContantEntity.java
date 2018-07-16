package com.hl95.utils.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 常量类
 * 
 * @author cheny
 *
 */
@Component("ContantEntity")
public class ContantEntity {
	
	//恒通移动账户Id
	@Value("${user.mUserId}")
	private String mUserId;
	
	//恒通移动账户账号
	@Value("${user.mAccount}")
	private String mAccount;
	
	//恒通移动账户密码
	@Value("${user.mPassword}")
	private String mPassword;
	
	//恒通联通账户Id
	@Value("${user.uUserId}")
	private String uUserId;
	
	//恒通联通账户账号
	@Value("${user.uAccount}")
	private String uAccount;
	
	//恒通联通账户密码
	@Value("${user.uPassword}")
	private String uPassword;
	
	//恒通移动账户Id
	@Value("${user.dUserId}")
	private String dUserId;
	
	//恒通移动账户账号
	@Value("${user.dAccount}")
	private String dAccount;
	
	//恒通移动账户密码
	@Value("${user.dPassword}")
	private String dPassword;

	
	public String getmUserId() {
		return mUserId;
	}

	public void setmUserId(String mUserId) {
		this.mUserId = mUserId;
	}

	public String getmAccount() {
		return mAccount;
	}

	public void setmAccount(String mAccount) {
		this.mAccount = mAccount;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getuUserId() {
		return uUserId;
	}

	public void setuUserId(String uUserId) {
		this.uUserId = uUserId;
	}

	public String getuAccount() {
		return uAccount;
	}

	public void setuAccount(String uAccount) {
		this.uAccount = uAccount;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getdUserId() {
		return dUserId;
	}

	public void setdUserId(String dUserId) {
		this.dUserId = dUserId;
	}

	public String getdAccount() {
		return dAccount;
	}

	public void setdAccount(String dAccount) {
		this.dAccount = dAccount;
	}

	public String getdPassword() {
		return dPassword;
	}

	public void setdPassword(String dPassword) {
		this.dPassword = dPassword;
	}
	
}
