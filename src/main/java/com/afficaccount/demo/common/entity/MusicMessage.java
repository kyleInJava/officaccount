package com.afficaccount.demo.common.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * 音乐消息
 * @author kyle
 *
 */
@Setter
@Getter 
@JacksonXmlRootElement(localName = "xml")
public class MusicMessage extends BaseMessage {


	@JacksonXmlProperty(localName = "Music")
	private Music music;
	
	public MusicMessage(){
		setMsgType("music");
		this.music = new Music();
	}
	
	public void setMusicInfo(String title, String description,String musicUrl,String hQMusicUrl,String thumbMediaId){
		this.music.setTitle(title);
		this.music.setDescription(description);
		this.music.setMusicUrl(musicUrl);
		this.music.setHQMusicUrl(hQMusicUrl);
		this.music.setThumbMediaId(thumbMediaId);
	}
	
	@Setter
	@Getter 
	private static class Music{
		
		@JacksonXmlProperty(localName = "Title")
		private String title ;
		
		@JacksonXmlProperty(localName = "Description")
		private String description ;
		
		@JacksonXmlProperty(localName = "MusicUrl")
		private String musicUrl ;
		
		@JacksonXmlProperty(localName = "HQMusicUrl")
		private String hQMusicUrl ;
		
		@JacksonXmlProperty(localName = "ThumbMediaId")
		private String thumbMediaId ;
	}
}
