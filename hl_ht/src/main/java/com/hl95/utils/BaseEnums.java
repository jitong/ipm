package com.hl95.utils;

/**
 * 
 * @ClassName:  BaseEnums   
 * @Description: 枚举公共类   
 * @author: chenY
 * @date:   2017-9-21 下午5:56:10     
 *
 */
public interface BaseEnums<V> {
	
	//实际值
	V getValue(); 
	//显示值
	String getText();
}
