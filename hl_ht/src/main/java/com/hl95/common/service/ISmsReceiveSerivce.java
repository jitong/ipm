package com.hl95.common.service;


import com.alibaba.fastjson.JSONArray;
import com.hl95.common.entity.MessageEntity;

/**
 * 
 * 阿里信息接口服务类
 * 
 * @author chenYan
 *
 */
public interface ISmsReceiveSerivce {

	/**
	 * 阿里上行短信接受处理
	 * 
	 * @param params 上行信息接受
	 * @return
	 */
	public MessageEntity receiveUponSms(JSONArray params);
}
