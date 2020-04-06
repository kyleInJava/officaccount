package com.afficaccount.demo.common.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter 
public class BaseMessage {
	
	@JacksonXmlProperty(localName = "ToUserName")
	private String toUserName;
	
	@JacksonXmlProperty(localName = "FromUserName")
	private String fromUserName;
	
	@JacksonXmlProperty(localName = "CreateTime")
	private int createTime;
	
	@JacksonXmlProperty(localName = "MsgType")
	private String msgType;


}
