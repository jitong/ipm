package com.hl95.utils;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 
 * 阿里短信接口工具类
 * 
 * @author chenyan
 *
 */
public class SmsUtil {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    //apK加密 密钥
    static final String accessKeyId = "LTAI3gwdkb0XfqHN";
    static final String accessKeySecret = "Gl0Qp4HQSQXzU4jyBfe1QjHFHRFhrE";
    
    /**
     * 短信发送接口
     * @param SendSmsRequest   短信发送接口入参
     * @return SendSmsResponse 短信发送接口返回值
     * @throws ClientException	
     */
    public static SendSmsResponse sendSms(SendSmsRequest request) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //调用阿里接口发送
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }
    
    public static void main(String[] args) throws ClientException, InterruptedException {

   }
}
