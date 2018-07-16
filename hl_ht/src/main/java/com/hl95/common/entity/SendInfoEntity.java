package com.hl95.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: SendInfoEntity  
 * @Description: 短信发送Entity
 * @author chenYan  
 * @date 2018年5月24日  
 */
public class SendInfoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	//批次号
	private String batchNo;
	
	//扩展号码
	private String subNum;
	
	//通道号
	private String cnum;
	
	//短信内容
	private String content;
	
	//手机号
	private String mobile;
	
	//短信发送时间
	private Date sendDate;
	
	//短信接受时间
	private Date receiveDate;
	
	//短信状态返回值
	private String returnMsg;

	
	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getSubNum() {
		return subNum;
	}

	public void setSubNum(String subNum) {
		this.subNum = subNum;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
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

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	} 
	
	
	
}
