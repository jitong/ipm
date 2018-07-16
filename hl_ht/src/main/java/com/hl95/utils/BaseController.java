package com.hl95.utils;


import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author chenyan
 *
 */
public class BaseController {
	
	
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}

	
	/** 
     * 把浏览器参数转化放到Map集合中 
     * @param request 
     * @return 
     * @throws UnsupportedEncodingException 
     */  
    public Map<String, Object> getParams(HttpServletRequest request) {  
        Map<String, Object> paramMap = new HashMap<String, Object>();  
        String method = request.getMethod();  
        Enumeration<?> keys = request.getParameterNames();  
        while (keys.hasMoreElements()) {  
            Object key = keys.nextElement();  
            if(key!=null){  
                if (key instanceof String) {  
                    String value = request.getParameter(key.toString());  
                    
                    if("GET".equals(method)){
                         try {  
                        	//前台encodeURIComponent('中文');转码后到后台还是ISO-8859-1，所以还需要转码  
                            value =new String(value.getBytes("ISO-8859-1"),"UTF-8");  
                            System.out.println(value);
                        } catch (UnsupportedEncodingException e) {  
                            e.printStackTrace();  
                        }      
                    }  
                    paramMap.put(key.toString(), value);  
                }  
            }   
        }  
        return paramMap;  
    }  

	/**
	 * 获取客户端IP
	 * @param request
	 * @return
	 */
	public String getRemoteHost(HttpServletRequest request){
		
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	
	
}
