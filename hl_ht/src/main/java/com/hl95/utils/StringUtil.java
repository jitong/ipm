package com.hl95.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 *
 * String 操作工具类
 * 
 * @author chenYan
 *
 */
public class StringUtil {
	
	
	/**
	 * 判断是否为空
	 * 
	 * @return
	 */
    public static boolean isBlank(Object obj) {
    	
    	if(obj==null) {
    		return true;
    	}
    	if(obj.toString().trim().length()==0) {
    		return true;
    	}
    	return false;
    }
    
    /**
	 * 判断是否为空
	 * 
	 * @return
	 */
    public static boolean isNotBlank(Object obj) {
    	
    	if(obj==null) {
    		return false;
    	}
    	if(obj.toString().trim().length()==0) {
    		return false;
    	}
    	return true;
    }
    /**
     * Object to String
     * @param obj
     * @return String or Null
     */
    public static String toString(Object obj) {
    	
    	if(obj==null) {
    		return null;
    	}
    	
    	return obj.toString();
    
    }
    
    /**
     * 
     * @Title: getUUID  
     * @Description: 获取32位小写UUID
     * @return String 32位UUID
     *
     */
    public static String getUUID() {
    	
    	return UUID.randomUUID().toString().replace("-", "");
    }
    
    
    public static void main(String[] args) throws UnsupportedEncodingException {
		
    	
    	System.out.println(URLEncoder.encode("短信内容","UTF-8"));
    	
	}
}
