package com.afficaccount.demo.common.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * 语音消息
 * @author kyle
 *
 */
@Setter
@Getter 
@JacksonXmlRootElement(localName = "xml")
public class VoiceMessage extends BaseMessage {

	@JacksonXmlProperty(localName = "Voice")
	private Voice voice;
	
	public VoiceMessage(){
		setMsgType("voice");
		this.voice = new Voice();
	}
	
	public void setVoiceInfo(String mediaId){
		
		this.voice.setMediaId(mediaId);
	}
	
	@Setter
	@Getter 
	private static class Voice{
		
		@JacksonXmlProperty(localName = "MediaId")
		private String mediaId ;
	}
}
