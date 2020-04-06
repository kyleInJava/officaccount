package com.afficaccount.demo.common.service;

import java.util.Map;

import com.afficaccount.demo.common.entity.BaseMessage;

public interface MessageAndEventService {

	BaseMessage handle(Map<String, String> requestMap);
	
}
