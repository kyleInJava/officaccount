package com.afficaccount.demo.common.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * 视频消息
 * @author kyle
 */
@Setter
@Getter 
@JacksonXmlRootElement(localName = "xml")
public class VideoMessage extends BaseMessage {

	@JacksonXmlProperty(localName = "Video")
	private Video video;
	
	public VideoMessage(){
		setMsgType("video");
		this.video = new Video();
	}
	
	public void setVideoInfo(String mediaId,String title, String description){
		
		this.video.setMediaId(mediaId);
		this.video.setTitle(title);
		this.video.setDescription(description);
	}
	
	@Setter
	@Getter 
	private static class Video{
		
		@JacksonXmlProperty(localName = "MediaId")
		private String mediaId ;
		
		@JacksonXmlProperty(localName = "Title")
		private String title ;
		
		@JacksonXmlProperty(localName = "Description")
		private String description ;
	}
	
}
