package com.afficaccount.demo.common.entity;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * 文本消息
 * @author kyle
 *
 */
@JacksonXmlRootElement(localName = "xml")
@Setter
@Getter 
public class TextMessage extends BaseMessage {
	
	@JacksonXmlProperty(localName = "Content")
	private String content;
	
	public TextMessage(){
		setMsgType("text");
	}
	
	public TextMessage(String toUserName,String fromUserName,String content){
		this(toUserName,fromUserName,(int)System.currentTimeMillis()/100,content);
	}
	
	public TextMessage(String toUserName,String fromUserName,int createTime,String content){
		setToUserName(toUserName);
		setFromUserName(fromUserName);
		setCreateTime(createTime);
		setContent(content);
		setMsgType("text");
	}

}
