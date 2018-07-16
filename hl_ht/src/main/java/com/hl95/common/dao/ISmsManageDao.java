package com.hl95.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hl95.common.entity.SendInfoEntity;
import com.hl95.common.entity.User;


/**
 * 
 * 短信接口操作类
 * @author chenYan
 *
 */
public interface ISmsManageDao {
	
	/**
	 * IP鉴权，根据Ip地址查询数据库白名单设置
	 * @param ipAddr ip地址
	 * @return 结果数量
	 */
	public int getIpAddrForValidate(@Param("ipAddr") String ipAddr);
	
	/**
	 * 用户身份信息校验
	 * @param params 用户信息canshu
	 * @return 结果数量
	 */
	public User getUserForValidate(Map<String, Object> params);
	
	/**
	 * 保存短信日志
	 * @param Params 日志参数
	 * @return 受影响行数
	 */
	public int saveMsgLog(Map<String, Object> params);
	
	/**
	 * 更新用户余额信息
	 * @param params
	 * @return
	 */
	public int updateUserBalance(@Param("user") User user);
	
	/**
	 * @Title: updateMsgLogStatus  
	 * @Description: 更新短信提交状态 
	 * @param params 传入参数
	 * @return int
	 *//*
	public int updateMsgLogStatus(List<Map<String, Object>> params);*/
	
	
	/**
	 * 
	 * @Title: updateMsgLogStatus  
	 * @Description: 更新短信发送状态
	 * @param list 
	 * @return
	 *
	 */
	public int updateMsgLogStatus(List<SendInfoEntity> list);
	
}
