package com.afficaccount.demo.common.service.impl;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afficaccount.demo.common.entity.AccessToken;
import com.afficaccount.demo.common.service.UserManagerService;

@Service
public class UserManagerServiceImpl implements UserManagerService {

	private static final String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?lang=zh_CN";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public String getUserInfo() {
		AccessToken token = (AccessToken)servletContext.getAttribute("accessToken");
		StringBuilder sb = new StringBuilder(USER_INFO_URL);
		sb.append("&access_token=").append(token.getAccess_token())
		  .append("&openid=").append("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		
		
		return restTemplate.getForObject(sb.toString(), String.class);
	}

}
