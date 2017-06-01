package com.tooklili.service.test.dataoke;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.tooklili.http.HttpCallService;
import com.tooklili.model.dataoke.DataokeRespModel;
import com.tooklili.service.test.BaseTest;
import com.tooklili.util.HttpClientUtil;
import com.tooklili.util.result.PlainResult;

import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;

/**
 * 大淘客接口测试
 * @author shuai.ding
 * @date 2017年5月27日下午3:16:34
 */
public class DataokeTest extends BaseTest{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataokeTest.class);

	private String appkey="6s4j6s8zrn";
	
	@Resource
	private HttpCallService httpCallService;
	
	/**
	 * 登录大淘客，获取淘口令
	 * @author shuai.ding
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void loginDataoke() throws ClientProtocolException, IOException{
		//1、获取token、random
		Map<String, String> cookies = HttpClientUtil.getCookiesByGet("http://www.dataoke.com/loginApi");
		String token = cookies.get("token");
		String random = cookies.get("random");
		LOGGER.info("token={};andom={}",token,random);
		
		//2、登录
		String cookies1= "token="+token+";random="+random;
		Map<String,String> params = Maps.newHashMap();
    	params.put("username", "18256915945");
    	params.put("password", "10205050132");
    	Map<String, String> responseCookies =  HttpClientUtil.getCookiesByPost("http://www.dataoke.com/loginApi", params, cookies1);
    	
    	//3、获取淘口令
    	String cookieStr = "";
        for (String cookieKey : responseCookies.keySet()) {
            cookieStr += cookieKey + "=" + responseCookies.get(cookieKey) + ";";
        } 
        String content = HttpClientUtil.get("http://www.dataoke.com/dtpwd?gid=12311550", cookieStr);
        LOGGER.info(content);
	}
	
	/**
	 * 全站领券商品API接口
	 * @author shuai.ding
	 */
	@Test
	public void quantotal(){
		String url ="http://api.dataoke.com/index.php?r=goodsLink/www&type=total&appkey="+appkey+"&v=2&page=200";
		
		PlainResult<String> result = httpCallService.httpGet(url);
		
		if(result.isSuccess()){
			String responseResult = result.getData();
			DataokeRespModel dataokeRespModel = JSON.parseObject(responseResult, DataokeRespModel.class);
			LOGGER.info(dataokeRespModel.getData().getApi_content());
		}
	}
}
