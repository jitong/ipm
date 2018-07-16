package com.hl95.common.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hl95.common.service.ISmsManageService;
import com.hl95.utils.BaseController;
import com.hl95.utils.entity.ResponEntity;
import com.hl95.utils.enums.MessageEnums;

/**
 * 短信接口管理类
 * 
 * @author chenYan
 *
 */
@Controller
@RequestMapping("/api/sms")
public class SmsManageController extends BaseController {
	
	private static Logger logger = Logger.getLogger(SmsManageController.class);
	
	@Autowired
	ISmsManageService iSmsmangeService;
	
	/**
	 * 彩信发送接口（目前支持单条发送）
	 * @param request 
	 * @return
	 */
	@RequestMapping(value = "/send",method = RequestMethod.POST)
	@ResponseBody
	public ResponEntity sendSms(){
		
		Map<String, Object> params  = this.getParams(getRequest());
		
		String remoteHost = this.getRemoteHost(getRequest());
		
		params.put("remoteHost", remoteHost);
		
		MessageEnums enums = null;
		
		try {
			enums = iSmsmangeService.sendMediaMessage(params);
		} catch (Exception e) {
			//待添加异常打印
			logger.error("短信发送发送遇到异常",e);
		}
		
		return ResponEntity.getResponEntityFromEnums(enums) ;
	}
	
	
}
