package com.hl95.common.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.exceptions.ClientException;
import com.hl95.common.dao.ISmsManageDao;
import com.hl95.common.entity.Manager;
import com.hl95.common.entity.SendInfoEntity;
import com.hl95.common.entity.User;
import com.hl95.common.service.ISmsManageService;
import com.hl95.utils.DateUtil;
import com.hl95.utils.StringUtil;
import com.hl95.utils.enums.MessageEnums;

/**
 * 
 * 短信接口服务实现类
 * @author chenYan
 *
 */
@Service
public class SmsManageServiceImpl implements ISmsManageService {
	
	private static Logger logger = Logger.getLogger(SmsManageServiceImpl.class);
	
	@Autowired
	private ISmsManageDao iSmsManageDao;
	
	/**
	 * 发送彩信接口
	 * @param	彩信信息参数
	 * @return	彩信发送结果
	 * @throws ClientException 
	 * @throws UnsupportedEncodingException 
	 */
	public MessageEnums sendMediaMessage(Map<String, Object> params) throws ClientException, UnsupportedEncodingException {
		
		//1、参数校验
		MessageEnums validateParamResult = this.validateParams(params);
		if(!MessageEnums.MessageEnums_08.equals(validateParamResult)) {
			logger.error(params);
			return validateParamResult;
		}
		
		//2、IP鉴权
		String remoteHost = StringUtil.toString(params.get("remoteHost"));
		int ipRows = iSmsManageDao.getIpAddrForValidate(remoteHost);
		
		if(ipRows<=0) {
			logger.error(params);
			return MessageEnums.MessageEnums_02;
		}
		
		//3、用户身份认证
		User user = iSmsManageDao.getUserForValidate(params);
		if(user==null) {
			logger.error(params);
			return MessageEnums.MessageEnums_03;
		}
		if("N".equals(user.getUserYn())) {
			logger.error(params);
			return MessageEnums.MessageEnums_06;
		}
		if("N".equals(user.getDelYn())) {
			logger.error(params);
			return MessageEnums.MessageEnums_07;
		}
		
		//4、获取请求参数入库
		SendInfoEntity sendInfoEntity = this.getSendInfoEntity(params);
		//待推送发送信息队列
		Manager.getInstance().addSms(sendInfoEntity);
		
		
		
		
		//5、短信发送入库
		Map<String, Object> returnParams = this.getMsgLogParams(params);
		iSmsManageDao.saveMsgLog(returnParams);
		
		return MessageEnums.MessageEnums_200;
	}
	
	/**
	 * 获取短信日志入库数据
	 * @param params   短信接口传入参数
	 * @param response 短信发送响应值
	 * @return 短信日志入库数据
	 */
	public Map<String, Object> getMsgLogParams(Map<String, Object> params){
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		returnMap.put("orgAddr", null);
		returnMap.put("destAddr", params.get("phone"));
		returnMap.put("message", params.get("message"));
		returnMap.put("modelId", null);
		returnMap.put("linkId", params.get("linkid"));
		returnMap.put("bizId", "");
		returnMap.put("requestId", params.get("requestId"));
		returnMap.put("statusCode", params.get("statusCode"));
		returnMap.put("addTime", DateUtil.getCurrentTimeStamp());
		returnMap.put("type", 60);
		returnMap.put("signame", "【"+params.get("signame")+"】");
		
		return returnMap;
	}
	
	/**
	 * 请求参数完整性校验
	 * @param params 参数值
	 * @return boolean 校验结果
	 */
	private MessageEnums validateParams(Map<String, Object> params) {
		
		//添加访问记录
		logger.info("请求参数="+params);
		
		String userName = StringUtil.toString(params.get("username"));	//用户账号
		String passWord = StringUtil.toString(params.get("password"));	//用户密码
		String phone = StringUtil.toString(params.get("phone"));		//电话号码
		String message = StringUtil.toString(params.get("message"));    //短信内容
		String signame = StringUtil.toString(params.get("signame"));    //短信签名
		String linkId = StringUtil.toString(params.get("linkid"));		//linkId
		String subcode = StringUtil.toString(params.get("subcode"));	//非必填，用户扩展码
		
		//设置请求ID
		params.put("requestId", StringUtil.getUUID());
		
		//非空字段不允许为空
		if(StringUtil.isBlank(userName)||StringUtil.isBlank(passWord)||StringUtil.isBlank(phone)||StringUtil.isBlank(message)||StringUtil.isBlank(signame)) {
			
			return MessageEnums.MessageEnums_614;
		}
		
		//手机格式不正常
		if(phone.length()<11) {
			
			return MessageEnums.MessageEnums_505;
		}
		
		//linkId超长
		if(linkId.length()>50) {
			
			return MessageEnums.MessageEnums_11;
		}
		
		//subcode超长
		if(StringUtil.isNotBlank(subcode)&&subcode.length()>5) {
			
			return MessageEnums.MessageEnums_12;
		}
		
		return MessageEnums.MessageEnums_08;
	}
	
	/**
	 * 
	 * @Title: getSendInfoEntity  
	 * @Description: 把请求参数转储SendInfoEntity
	 * @param params 
	 * @return SendInfoEntity
	 */
	public SendInfoEntity getSendInfoEntity(Map<String, Object> params) {
		
		SendInfoEntity sendInfoEntity = new SendInfoEntity();
		
		sendInfoEntity.setMobile(params.get("phone").toString());
		sendInfoEntity.setContent("【"+params.get("signame").toString()+"】"+params.get("message").toString());
		sendInfoEntity.setSubNum(null);
		sendInfoEntity.setBatchNo(params.get("requestId").toString());
		sendInfoEntity.setSendDate(new Date());
		
		return sendInfoEntity;
	}
	
	/**
	 * @Title: updateMsgLogStatus  
	 * @Description: 更新短信发送状态
	 * @param list 
	 * @return
	 */
	public int updateMsgLogStatus(List<SendInfoEntity> list) {
		
		return iSmsManageDao.updateMsgLogStatus(list);
	}
	
}
