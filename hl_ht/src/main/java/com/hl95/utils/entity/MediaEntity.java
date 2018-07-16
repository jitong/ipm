package com.hl95.utils.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: MediaEntity  
 * @Description: 彩信实体类
 * @author chenYan  
 * @date 2018年5月30日  
 *
 */
public class MediaEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	//操作类型
	private String action;
	
	//用户id
	private String userId;
	
	//用户账号
	private String account;
	
	//用户密码
	private String passWord;
	
	//彩信标题
	private String title;
	
	//彩信内容
	private String content;
	
	//手机号码
	private String mobile;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
