package com.afficaccount.demo.common.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afficaccount.demo.common.entity.BaseMessage;
import com.afficaccount.demo.common.service.MessageAndEventService;
import com.afficaccount.demo.util.WeixinUtil;

@RestController
@RequestMapping("/offiaccount")
public class MessageAndEventController {
	
	@Autowired
	private MessageAndEventService eventHandler;
	
	/**
	 * 校验信息是否来自微信服务器
	 * @param signature  微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp  时间戳
	 * @param nonce		  随机数
	 * @param echostr	 如果校验成功就返回该字符串
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String check(String signature, String timestamp, String nonce, String echostr){
		
		boolean checkResult = WeixinUtil.checkMessageSource(signature, timestamp, nonce);
		if(checkResult == true){
			return echostr;
		}
		return "校验失败";
	}
	
	
	/**
	 * 接收消息和事件推送,这个方法返回的是xml文档
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.POST,produces = {"application/xml;charset=UTF-8"})
	public BaseMessage handlMessageAndEvent(HttpServletRequest request ) throws IOException{
		
		Map<String, String> requestMap = WeixinUtil.parseXml(request);
		System.out.println(requestMap);
		BaseMessage message = eventHandler.handle(requestMap);
		
		return message;
		
	}
	
	
}
