package com.hl95.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import sun.tools.tree.ThisExpression;

public class CaixinTest {

	
	
	public static void main(String[] args) throws Exception {
		
		//恒通电信
		htdx();
		
		//恒通移动
		//htyd();
		
		//System.out.println(getContent());
	}
	
	
	public static void htdx() throws Exception {
		
		String url="http://47.92.67.88:8888/sendmms.aspx";
		//POST的URL
		HttpPost httppost=new HttpPost(url);
		//建立HttpPost对象
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		//建立一个NameValuePair数组，用于存储欲传送的参数
		params.add(new BasicNameValuePair("action","send"));
		params.add(new BasicNameValuePair("userid","39"));
		params.add(new BasicNameValuePair("account","Hongl02"));
		params.add(new BasicNameValuePair("password","Hongl0525"));
		params.add(new BasicNameValuePair("title","【万达集团】"));
		params.add(new BasicNameValuePair("content",getContent()));
		//17319409506
		params.add(new BasicNameValuePair("mobile","18612937483"));
		//添加参数
		httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

		//设置编码
		HttpResponse response=new DefaultHttpClient().execute(httppost);
		//发送Post,并返回一个HttpResponse对象
		if(response.getStatusLine().getStatusCode()==200){//如果状态码为200,就是正常返回
			String result=EntityUtils.toString(response.getEntity());
			System.out.println(result);
		}
	}
	
	public static void htyd() throws Exception {
		
		String url="http://47.92.67.88:8888/sendmms.aspx";
		//POST的URL
		HttpPost httppost=new HttpPost(url);
		//建立HttpPost对象
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		//建立一个NameValuePair数组，用于存储欲传送的参数
		params.add(new BasicNameValuePair("action","send"));
		params.add(new BasicNameValuePair("userid","35"));
		params.add(new BasicNameValuePair("account","Hongljw"));
		params.add(new BasicNameValuePair("password","Hongljw0327"));
		params.add(new BasicNameValuePair("title","【万达集团】"));
		params.add(new BasicNameValuePair("content",getContent()));
		params.add(new BasicNameValuePair("mobile","13716072540"));
		//添加参数
		httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

		//设置编码
		HttpResponse response=new DefaultHttpClient().execute(httppost);
		//发送Post,并返回一个HttpResponse对象
		if(response.getStatusLine().getStatusCode()==200){//如果状态码为200,就是正常返回
			String result=EntityUtils.toString(response.getEntity());
			System.out.println(result);
		}
	}
	
	

	
	private static String getContent() throws Exception{
		String txt = "文本测试";
		String imgFileString = "D:\\test3.jpg";
		
		
		String content = "3,";
		content += "txt|"+Base64.encodeBase64String(txt.getBytes("gb2312"))+",";
		content += "jpg|"+getImgStr(imgFileString);
		
		return content;
	}
	
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
