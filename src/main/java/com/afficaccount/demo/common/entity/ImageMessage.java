package com.afficaccount.demo.common.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片消息
 * @author kyle
 */
@Setter
@Getter 
@JacksonXmlRootElement(localName = "xml")
public class ImageMessage extends BaseMessage {
	
	@JacksonXmlProperty(localName = "Image")
	private Image image;
	
	public ImageMessage(){
		setMsgType("image");
		this.image = new Image();
	}
	
	public void setImageInfo(String mediaId){
		this.image.setMediaId(mediaId);
	}
	
	@Setter
	@Getter 
	private static class Image{
		
		@JacksonXmlProperty(localName = "MediaId")
		private String mediaId ;
	}

}
