package com.afficaccount.demo.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afficaccount.demo.common.entity.AuthAccessToken;
import com.afficaccount.demo.common.service.WebPageAuthorizationService;

@RestController
@RequestMapping("authorization")
public class WebPageAuthorizationController {

	
	@Autowired
	private WebPageAuthorizationService webPageAuthorizationService;
	
	@RequestMapping("getinfo")
	private String authorizationInfo(String code,String state){
		AuthAccessToken token = webPageAuthorizationService.getAccessToken(code,state);
		return webPageAuthorizationService.getAuthorizationInfo(token);
	}
}
