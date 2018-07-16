package com.hl95.common.entity;

import java.io.Serializable;

/**
 * 阿里短信上行返回对象
 * 
 * @author chenYan
 *
 */
public class MessageEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	//响应编码
	private Integer code = 0;
	
	//响应信息
	private String msg = "接受成功";
	
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
