package com.hl95.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: PhoneUtils  
 * @Description:  手机号码处理程序
 * @author chenYan  
 * @date 2018年5月23日  
 *
 */
public class PhoneUtils {

	
	/**
	 * @Title: isPhoneNumber  
	 * @Description: 判断手机号是否为国内手机号
	 * @param mobiles 手机号码
	 * @return boolean 是否是国内手机号
	 */
	public static boolean isPhoneNumber(String mobiles) {
        boolean flag = false;
        /**
         * 13*12345678
         */
        String str4Pattern = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0,5-9])|(14[0,5-9]))\\d{8}$";
        str4Pattern = "^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\\d{8}$";
        /**
         * 13-19
         */
        str4Pattern = "^1[3-9]\\d{9}$";

        try {
            Pattern p = Pattern.compile(str4Pattern);
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
            if (!flag) {
                String tregEx = "[0]{1}[0-9]{2,3}-[0-9]{7,8}"; // 表示a或f //  // 0832-80691990
                flag = Pattern.compile(tregEx).matcher(mobiles).find();
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
