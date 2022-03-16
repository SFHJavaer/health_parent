// This file is auto-generated, don't edit it. Thanks.
package com.utils;

import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.*;
import com.aliyun.teaopenapi.models.*;
import com.aliyun.teaconsole.*;
import com.aliyun.teautil.*;


public class SMSUtils {

	/**
	 * 使用AK&SK初始化账号Client
	 * @param accessKeyId
	 * @param accessKeySecret
	 * @return Client
	 * @throws Exception
	 */
	public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
		Config config = new Config()
				// 您的AccessKey ID
				.setAccessKeyId(accessKeyId)
				// 您的AccessKey Secret
				.setAccessKeySecret(accessKeySecret);
		// 访问的域名
		config.endpoint = "dysmsapi.aliyuncs.com";
		return new com.aliyun.dysmsapi20170525.Client(config);
	}

	public static void main(String telephone,String param) throws Exception {
//		java.util.List<String> args = java.util.Arrays.asList(args_);
//		System.out.println(args);
		com.aliyun.dysmsapi20170525.Client client = SMSUtils.createClient("自行填写accessKeyId", "accessKeySecret");
//		com.aliyun.dysmsapi20170525.Client client = SMSUtils.createClient("accessKeyId", "accessKeySecret");
		SendSmsRequest sendSmsRequest = new SendSmsRequest()
				.setSignName("阿里云短信测试")
				.setTemplateCode("SMS_154950909")
				.setPhoneNumbers(telephone)
				.setTemplateParam("{\"code\":\"" + param + "\"}");

		// 复制代码运行请自行打印 API 的返回值
		SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
		com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(TeaModel.buildMap(sendSmsResponse)));

	}
}
