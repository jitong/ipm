package com.hl95.utils.entity;

import java.util.HashMap;

import com.hl95.utils.BaseEnums;

/**
 * 
 * @author chenyan
 *
 */
public class ResponEntity extends HashMap<String, Object>{

	private static final long serialVersionUID = 1L;

	public ResponEntity() {
	}
	
	public static ResponEntity getResponEntityFromEnums(BaseEnums<String> enums) {
		
		ResponEntity responEntity = new ResponEntity(); 
		
		responEntity.put(enums.getValue(), enums.getText());
		
		return responEntity;
	}

}
