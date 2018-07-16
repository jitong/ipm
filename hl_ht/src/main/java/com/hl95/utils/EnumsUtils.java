package com.hl95.utils;


import java.util.EnumSet;

import com.hl95.utils.enums.SmsModelEnums;

/**
 * 
 * @ClassName:  EnumsUtils   
 * @Description: 枚举工具类  
 * @author: chenY
 * @date:   2017-9-21 下午6:09:12     
 *
 */
public class EnumsUtils {

	/**
	 * 
	 * @Title: getByValue    
	 * @Description: 根据枚举key获取枚举value   
	 * @author: chenY  
	 * @date:   2017-9-21 下午6:11:23 
	 * @param:  clazz	枚举类信息
	 * @param:  id
	 * @return: T
	 */
	public static <T extends Enum<T> & BaseEnums<V>, V> T getByValue(Class<T> clazz, V id) {
		EnumSet<T> set = EnumSet.allOf(clazz);
		for (T t : set) {
			if (t.getValue().equals(id)) {
				return t;
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: getByText   
	 * @Description: 根据value获取key
	 * @author: chenY  
	 * @date:   2017-9-21 下午6:11:57 
	 * @param:  clazz
	 * @param:  text
	 * @return: T
	 */
	public static <T extends Enum<T> & BaseEnums<V>, V> T getByText(Class<T> clazz, String text) {

		EnumSet<T> set = EnumSet.allOf(clazz);
		for (T t : set) {
			if (t.getText().equals(text)) {
				return t;
			}
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		
		SmsModelEnums sEnums = EnumsUtils.getByValue(SmsModelEnums.class, "DIGITAL_SMS_127955072");
		
		System.out.println(sEnums.getText());
	}
}
