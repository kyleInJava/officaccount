package com.afficaccount.demo.common.service.impl;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afficaccount.demo.common.entity.AccessToken;
import com.afficaccount.demo.common.service.AccessTokenService;

@Service
public class AccessTokenServiceImpl implements  AccessTokenService{
	
	private static final String APPID = "wx202f42d8744a989e";

	private static final String APPSECRET = "8eefdf867c794ce86dfd892c2df14f0e";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ServletContext servletContext;
	
	public AccessToken getAccessToken(){
		StringBuilder sb = new StringBuilder();
		sb.append("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=")
		  .append(APPID).append("&secret=").append(APPSECRET);
		AccessToken token =restTemplate.getForObject(sb.toString(), AccessToken.class);
		servletContext.setAttribute("accessToken", token);//把token存起来，方便后面用。
		System.err.println(token);
		return token;
		
	}
	
	

}
