package com.hl95.utils.enums;

import com.hl95.utils.BaseEnums;

/**
 * 彩信模板枚举类
 * 
 * @author chenYan
 *
 */
public enum SmsModelEnums implements BaseEnums<String> {
	
	SmsModelEnums_01("DIGITAL_SMS_127955072","阿里云短信测试专用"),
	SmsModelEnums_02("DIGITAL_SMS_130985135","万达电影"),
	SmsModelEnums_03("DIGITAL_SMS_130990125","咪咕影院"),
	SmsModelEnums_04("DIGITAL_SMS_130985312","咪咕影院"),
	SmsModelEnums_05("DIGITAL_SMS_130985313","万达电影");

	/** 状态key */
	private String value;
	/** 状态值 */
	private String text;
	
	
	private SmsModelEnums(String value, String text) {
		this.value = value;
		this.text = text;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return this.text;
	}
	
}
