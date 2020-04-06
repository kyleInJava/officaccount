package com.afficaccount.demo.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afficaccount.demo.common.service.TemplateMessageService;

/**
 * 模板消息
 * @author kyle
 *
 */
@RestController
@RequestMapping("templateMessage")
public class TemplateMessageController {
	
	@Autowired
	private TemplateMessageService templateMessageService;
	
	/**
	 * 设置行业
	 * @return
	 */
	@RequestMapping("/setIndustry")
	public String setIndustry(){
		String industry = "{\"industry_id1\":\"1\",\"industry_id2\":\"4\"}";
		return templateMessageService.setIndustry(industry);
	}
	
	/**
	 * 获取行业
	 * @return
	 */
	@RequestMapping("/getIndustry")
	public String getIndustry(){
		return templateMessageService.getIndustry();
	}
	
	/**
	 * 发送模板消息
	 * @return
	 */
	@RequestMapping("/sendMessage")
	public String sendTemplateMessage(){
		return templateMessageService.sendTemplateMessage();
	}

}
