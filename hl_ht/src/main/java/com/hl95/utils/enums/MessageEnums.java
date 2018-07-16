package com.hl95.utils.enums;

import com.hl95.utils.BaseEnums;

/**
 * 
 * @author chenYan
 *
 */
public enum MessageEnums implements BaseEnums<String>{
	
	//系统参数类型枚举
	MessageEnums_00("OK", "请求成功！"), 
	MessageEnums_01("isv.INVALID_PARAMETERS", "参数不完整，请检查所带的参数名以及格式是否都正确 ！"),
	MessageEnums_02("isv.IP_NOT_FOUND", "IP鉴权失败,请联系管理员！"),
	MessageEnums_03("isv.USER_NOT_FOUND", "用户身份校验失败，请核对您的用户名和密码！"),
	MessageEnums_04("isv.FAILED", "发送失败!"),
	MessageEnums_05("isv.SMS_TEMPLATE_ILLEGAL", "模板不合法!"),
	MessageEnums_06("isv.USER_OUT_SERVICE", "用户已经停用！"),
	MessageEnums_07("isv.USER_BLACK_LIST", "黑名单用户！"),
	MessageEnums_08("isv.VALIDATE_SUSSCES", "参数校验成功"),
	MessageEnums_09("isv.USER_BALACE_LESS", "用户账户余额不足！"),
	MessageEnums_10("isv.PHONE_FORM_ERROR","手机号格式正确"),
	MessageEnums_11("isv.LINKID_TOO_LONG","linkId不能超出50位"),
	MessageEnums_12("isv.SUBCODE_TOO_LONG","subcode不能超出5位"),
	MessageEnums_13("isv.SIGNNAME_NOT_FOUND","模板不存在"),
	
	MessageEnums_200("200", "OK!"),
	MessageEnums_500("500", "Internal Server Error!"),
	MessageEnums_501("501", "Missing username!"),
	MessageEnums_502("502", "Missing password!"),
	MessageEnums_503("503", "Missing source address!"),
	MessageEnums_504("504", "Missing message content!"),
	MessageEnums_505("505", "Missing recipient list!"),
	MessageEnums_507("507", "source address (include prefix) is too long (longer than 18 digits)"),
	MessageEnums_508("508", "Incorrect message type!"),
	MessageEnums_509("509", "Incorrect recipient number!"),
	MessageEnums_521("521", "Authenticate error!"),
	MessageEnums_522("522", "User account disabled!"),
	MessageEnums_531("531", "Message quota exceed!"),
	MessageEnums_601("601", "Source address is not valid!"),
	MessageEnums_602("602", "Customer IP address is not valid!"),
	MessageEnums_603("603", "SMS Submission failed!"),
	MessageEnums_604("604", "Validate customer white list failed!"),
	MessageEnums_605("605", "Validate customer black list failed!"),
	MessageEnums_606("606", "Validate global black list failed!"),
	MessageEnums_607("607", "Validate global white list failed!"),	
	MessageEnums_608("608", "Incorrect delay value!"),
	MessageEnums_609("609", "Incorrect channel (OA suffix) value!"),
	MessageEnums_610("610", "Invalid validity!"),
	MessageEnums_611("611", "SMPP routing not found!"),
	MessageEnums_612("612", "Subaddress is not supported!"),
	MessageEnums_613("613", "Incorrect priority setting!"),
	MessageEnums_614("614", "Incorrect request type value!"),
	MessageEnums_615("615", "Missing WAP URL!"),
	MessageEnums_616("616", "Invalid protocol ID!"),
	MessageEnums_617("617", "No matched numeric OA!"),
	MessageEnums_888("888", "Generic error!");


	/** 状态key */
	private String value;
	/** 状态值 */
	private String text;
	
	
	private MessageEnums (String value, String text){
		this.value = value;
		this.text = text;
	}
	
    public String getValue() {
		return this.value;
	}

    public String getText() {
		return this.text;
	}
	
}
