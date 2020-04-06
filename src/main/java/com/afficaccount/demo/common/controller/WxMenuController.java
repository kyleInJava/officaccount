package com.afficaccount.demo.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afficaccount.demo.common.service.WxMenuService;

/**
 * 操作微信公众号菜单
 * @author kyle
 *
 */
@RestController
@RequestMapping("menu")
public class WxMenuController {

	@Autowired
	private WxMenuService wxMenuService;
	
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String createMenu(){
		
		return wxMenuService.createMenu();
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String getMenu(){
		return wxMenuService.getMenu();
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteMenu(){
		return wxMenuService.deleteMenu();
	}
	
	
	
}
