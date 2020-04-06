package com.afficaccount.demo.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afficaccount.demo.common.service.UserManagerService;

@RestController
@RequestMapping("usermanager")
public class UserManagerController {

	
	@Autowired
	private UserManagerService userManagerService;
	
	@RequestMapping("get")
	public String getUserInfo(){
		return userManagerService.getUserInfo();
	}
	
	
}
