package com.hl95.common.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hl95.common.dao.ISmsManageDao;
import com.hl95.common.entity.MessageEntity;
import com.hl95.common.service.ISmsReceiveSerivce;
import com.hl95.utils.StringUtil;

@Service
public class SmsReceiveServiceImpl implements ISmsReceiveSerivce{

	@Autowired
	private ISmsManageDao iSmsManageDao;
	/**
	 * 阿里上行短信接受处理
	 * 
	 * @param params 上行信息接受
	 * @return
	 */
	public MessageEntity receiveUponSms(JSONArray params) {
		
		MessageEntity messageEntity = new MessageEntity();
		
		//参数处理
		this.isValidateParams(params);
		
		int rows = iSmsManageDao.saveMsgLog(null);
		if(rows>0) {
			messageEntity.setCode(0);
			messageEntity.setMsg("接受成功！");
		}
		
		return messageEntity;
	}
	
	
	private boolean isValidateParams(JSONArray params) {
		
//		phone_number	String	手机号码	13900000001	必须
//		send_time	String	发送时间	2017-01-01 00:00:00	必须
//		content	String	发送内容	这是一条上行短信	必须
//		sign_name	String	签名信息	xxxx	可选
//		dest_code	String	扩展号码	1234	必须
//		sequence_id	Number	序列号	1234567890	必须
		
//		values(#{orgAddr},#{destAddr},#{message},#{modelId},#{linkId},#{bizId},#{requestId},#{statusCode},#{statusMessage},#{sendUrl},#{addTime},#{type});
		//Map<String, Object> initParams = new HashMap<String, Object>();
		
		for (int i = 0; i < params.size(); i++) {
			
			JSONObject param = params.getJSONObject(i);
			
			String phoneNumber = StringUtil.toString(param.get("phone_number"));
		 	String sendTime = StringUtil.toString(param.get("send_time"));
			String content = StringUtil.toString(param.get("content"));
			String signName = StringUtil.toString(param.get("sign_name"));
			String destCode = StringUtil.toString(param.get("dest_code"));
			//暂时不使用
			//String sequenceId = StringUtil.toString(params.get("sequence_id"));
			
			param.put("orgAddr", phoneNumber);
			param.put("destAddr", destCode);
			param.put("message", signName+content);
			param.put("modelId", null);
			param.put("linkId", null);
			param.put("bizId", null);
			param.put("requestId", null);
			param.put("statusCode", "OK");
			param.put("statusMessage", null);
			param.put("sendUrl", null);
			param.put("type", "62");
			param.put("addTime", sendTime);
			
		}
		
	 	
		
		return true;
	}
	

}
