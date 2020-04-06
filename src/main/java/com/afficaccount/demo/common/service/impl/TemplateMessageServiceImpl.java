package com.afficaccount.demo.common.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.afficaccount.demo.common.entity.AccessToken;
import com.afficaccount.demo.common.entity.TemplateMessage;
import com.afficaccount.demo.common.service.TemplateMessageService;

@Service
public class TemplateMessageServiceImpl implements TemplateMessageService {
	
	private static final String SET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
	private static final String GET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=";
	private static final String SEND_TEMPLATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public String setIndustry(String industry) {
		AccessToken token = (AccessToken)servletContext.getAttribute("accessToken");
		return restTemplate.postForObject(SET_INDUSTRY_URL+token.getAccess_token(), industry, String.class);
	}

	@Override
	public String getIndustry() {
		AccessToken token = (AccessToken)servletContext.getAttribute("accessToken");
		return restTemplate.getForObject(GET_INDUSTRY_URL+token.getAccess_token(), String.class);
	}

	@Override
	public String sendTemplateMessage() {
		
		TemplateMessage tm = new TemplateMessage();
		tm.setTouser("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setTemplate_id("2IznLBGOkL0dIcYDF0Yhxv1ue50vOMApcvQH0s40HyE");
		tm.setUrl("http://www.baidu.com");
		Map<String,Map<String,String>> map = new HashMap<>();
		Map<String,String> first = new HashMap<>();
		first.put("value", "面试结果通知");
		first.put("color", "#173177");
		Map<String,String> company = new HashMap<>();
		company.put("value", "XXX有限公司");
		company.put("color", "#173177");
		Map<String,String> time = new HashMap<>();
		time.put("value", "2020年4月30日");
		time.put("color", "#173177");
		Map<String,String> result = new HashMap<>();
		result.put("value", "恭喜面试通过");
		result.put("color", "#173177");
		Map<String,String> remark = new HashMap<>();
		remark.put("value", "尽快来报道");
		remark.put("color", "#173177");
		tm.setData(map);
		map.put("first", first);
		map.put("company", company);
		map.put("time", time);
		map.put("result", result);
		map.put("remark", remark);
		
		AccessToken token = (AccessToken)servletContext.getAttribute("accessToken");
		return restTemplate.postForObject(SEND_TEMPLATE_MESSAGE_URL+token.getAccess_token(), JSON.toJSONString(tm), String.class);
		
	}

}
