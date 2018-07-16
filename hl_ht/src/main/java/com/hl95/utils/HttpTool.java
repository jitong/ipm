package com.hl95.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;





public class HttpTool {
	
	private static Logger logger = Logger.getLogger(HttpTool.class);
    /**
     * 发送post请求
     * 
     * @author Michael 
     * @param params
     *            参数
     * @param requestUrl
     *            请求地址
     * @param authorization
     *            授权书
     * @return 返回结果
     * @throws IOException
     */
    public static String sendPost(String params, String requestUrl, String authorization) throws IOException {

        byte[] requestBytes = params.getBytes("utf-8"); // 将参数转为二进制流
        HttpClient httpClient = new HttpClient();		// 客户端实例化
        PostMethod postMethod = new PostMethod(requestUrl);
        //设置请求头Authorization
        //postMethod.setRequestHeader("Authorization", "Basic " + authorization);
        // 设置请求头  Content-Type
        postMethod.setRequestHeader("Content-Type", "text/html");
        InputStream inputStream = new ByteArrayInputStream(requestBytes, 0, requestBytes.length);
        //请求体
        RequestEntity requestEntity = new InputStreamRequestEntity(inputStream, requestBytes.length, "text/html; charset=utf-8"); 
        postMethod.setRequestEntity(requestEntity);
        httpClient.executeMethod(postMethod);// 执行请求
        InputStream soapResponseStream = postMethod.getResponseBodyAsStream();// 获取返回的流
        byte[] datas = null;
        try {
            datas = readInputStream(soapResponseStream);// 从输入流中读取数据
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = new String(datas, "UTF-8");// 将二进制流转为String
        //打印返回结果
        System.out.println(result);

        return result;
    }

    /**
     * 从输入流中读取数据
     * 
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();
        return data;
    }
    
    
    
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    
    
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return result 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line+",";
            }
            
            if(null!=result&&result.length()>0)
            result = result.substring(0, result.length()-1);
           
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
            	System.out.println("输入流关闭是发生异常"+e);
                e.printStackTrace();
            }
        }
        return result;
    }
    
    
    /** 
     * get请求 
     * @return 
     */  
    public static String apacheSendGet(String url,String params) {  
    	
    	String urlStr = url+"?"+params;
        try {  
        	org.apache.http.client.HttpClient client = HttpClients.createDefault();
            //发送get请求  
            HttpGet request = new HttpGet(urlStr);  
            HttpResponse response = client.execute(request);  
   
            /**请求发送成功，并得到响应**/  
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {  
            	logger.info("get发送成功！");
                /**读取服务器返回过来的json字符串数据**/  
                String strResult = EntityUtils.toString(response.getEntity());  
                  
                return strResult;  
            }  
        }   
        catch (IOException e) {  
            logger.error("get请求失败！",e);
        }  
          
        return null;  
    } 
}
