package com.afficaccount.demo.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.afficaccount.demo.common.entity.AccessToken;
import com.afficaccount.demo.common.entity.Button;
import com.afficaccount.demo.common.service.AccessTokenService;

@RestController
@RequestMapping("token")
public class AccessTokenController {

	@Autowired
	private AccessTokenService accessTokenService;
	
	/**
	 * 手动刷新token
	 * @return
	 */
	@RequestMapping(value="refresh",method=RequestMethod.GET)
	public AccessToken refreshAccessToken(){
		return accessTokenService.getAccessToken();
	}
	
	
}
