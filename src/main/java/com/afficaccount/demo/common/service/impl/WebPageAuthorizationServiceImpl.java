package com.afficaccount.demo.common.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.afficaccount.demo.common.entity.AuthAccessToken;
import com.afficaccount.demo.common.service.WebPageAuthorizationService;

@Service
public class WebPageAuthorizationServiceImpl implements WebPageAuthorizationService {
	
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	private static final String AUTHOIZATION_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public AuthAccessToken getAccessToken(String code, String state) {
		String url = ACCESS_TOKEN_URL.replace("APPID", "wx202f42d8744a989e")
									.replace("SECRET", "8eefdf867c794ce86dfd892c2df14f0e")
									.replace("CODE", code);
		
		String forObject = restTemplate.getForObject(url, String.class);
		System.out.println(forObject);
		AuthAccessToken parseObject = JSON.parseObject(forObject,AuthAccessToken.class);
		System.out.println(parseObject);
		return parseObject;
	}

	@Override
	public String getAuthorizationInfo(AuthAccessToken token) {
System.out.println(token);
		String url = AUTHOIZATION_INFO_URL.replace("ACCESS_TOKEN", token.getAccess_token())
				.replace("OPENID", token.getOpenid());
		return restTemplate.getForObject(url, String.class);
	}

}
