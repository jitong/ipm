package com.hl95.common.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.aliyuncs.exceptions.ClientException;
import com.hl95.common.entity.SendInfoEntity;
import com.hl95.utils.enums.MessageEnums;

/**
 * 短信接口服务类
 * @author chenYan
 *
 */
public interface ISmsManageService {
	
	/**
	 * 发送短信接口
	 * @param	彩信信息参数
	 * @return	彩信发送结果
	 */
	public MessageEnums sendMediaMessage(Map<String, Object> params)  throws ClientException, UnsupportedEncodingException;

	/**
	 * @Title: updateMsgLogStatus  
	 * @Description: 更新短信发送状态
	 * @param list 
	 * @return
	 */
	public int updateMsgLogStatus(List<SendInfoEntity> list);
}
