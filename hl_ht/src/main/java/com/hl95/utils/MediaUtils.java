package com.hl95.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.hl95.utils.entity.MediaEntity;


/**
 * 
 * @ClassName: MediaUtils  
 * @Description: 彩信发送工具类
 * @author chenYan  
 * @date 2018年5月30日  
 *
 */
public class MediaUtils {

	
	/**
	 * 
	 * @Title: sendMediaSms  
	 * @Description: 发送彩信
	 * @param url 彩信提交地址
	 * @param mediaEntity 彩信实体类
	 * @return 彩信发送响应值
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 *
	 */
	@SuppressWarnings("all")
	public static String sendMediaSms(String url, MediaEntity mediaEntity) throws Exception {
		
		String result = "faild";
		
		//POST的URL
		HttpPost httppost=new HttpPost(url);
		//建立HttpPost对象
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		//建立一个NameValuePair数组，用于存储欲传送的参数
		params.add(new BasicNameValuePair("action", mediaEntity.getAction()));
		params.add(new BasicNameValuePair("userid", mediaEntity.getUserId()));
		params.add(new BasicNameValuePair("account", mediaEntity.getAccount()));
		params.add(new BasicNameValuePair("password", mediaEntity.getPassWord()));
		params.add(new BasicNameValuePair("title", mediaEntity.getTitle()));
		params.add(new BasicNameValuePair("content", mediaEntity.getContent()));
		params.add(new BasicNameValuePair("mobile", mediaEntity.getMobile()));
		//添加参数
		httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

		//设置编码
		HttpResponse response=new DefaultHttpClient().execute(httppost);
		//发送Post,并返回一个HttpResponse对象
		if(response.getStatusLine().getStatusCode()==200){//如果状态码为200,就是正常返回
			result=EntityUtils.toString(response.getEntity());
		}
		
		return result;
	}
	
	
	public static String getContent(String txt, String imgFileString) throws Exception{
		/*String txt = "文本测试";
		String imgFileString = "D:\\test3.jpg"*/;
		String content = "3,";
		content += "txt|"+Base64.encodeBase64String(txt.getBytes("gb2312"))+",";
		content += "jpg|"+getImgStr(imgFileString);
		
		return content;
	}
	
	/**
	 * @Title: getImgStr  
	 * @Description: 图片进行Base64位加密
	 * @param imgFile 图片路径
	 * @return	Base64加密后的内容
	 */
	public static String getImgStr(String imgFile){
        //将图片文件转化为字节数组字符串，并对其进行Base编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try 
        {
            in = new FileInputStream(imgFile);        
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(data));
    }
	
	
	
	
}
