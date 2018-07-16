package com.hl95.common.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hl95.common.entity.MessageEntity;
import com.hl95.common.service.ISmsReceiveSerivce;
import com.hl95.utils.BaseController;

@Controller
public class SmsReceiveController extends BaseController {

	private static Logger logger = Logger.getLogger(SmsReceiveController.class);
	
	@Autowired
	private ISmsReceiveSerivce iSmsReceiveSerivce;
	
	
	@RequestMapping(value = "/report",method = RequestMethod.POST)
	@ResponseBody
	public MessageEntity getReportParams() {
		
		Map<String, Object> params  = this.getParams(getRequest());
		logger.info("状态参数="+params);
		
		iSmsReceiveSerivce.receiveUponSms(null);
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/upon",method = RequestMethod.POST)
	@ResponseBody
	public MessageEntity getUponParams(@RequestBody JSONArray params) {
//		Map<String, Object> params  = this.getParams(getRequest());
	
		logger.info("上行参数="+params);
		
		return null;
		//return iSmsReceiveSerivce.receiveUponSms(params);
	}
	
	public static void main(String[] args) {
		
		Object obj = "[{send_time=2018-04-10 18:32:36, report_time=2018-04-10 18:32:36, success=false, err_msg=运营商未知错误, err_code=SP_UNKNOWN_ERROR, phone_number=13716072540, sms_size=1, biz_id=732623723356355980^0, out_id=yourOutId}]";
		
		JSONObject json = JSONObject.parseObject(obj.toString());
		
		System.out.println(json);
		
	}
}
