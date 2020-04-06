package com.afficaccount.demo.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.Setter;

/**
 * 图文消息
 * @author kyle
 */
@Setter
@Getter 
@JacksonXmlRootElement(localName = "xml")
public class ArticlesMessage extends BaseMessage {
	
	@JacksonXmlProperty(localName = "ArticleCount")
	private String articleCount;
	
	@JacksonXmlElementWrapper(localName = "Articles")
	@JacksonXmlProperty(localName ="item") 
	private List<Articles> articles;
	
	public ArticlesMessage(){
		setMsgType("news");
		this.articles = new ArrayList<>();
	}
	
	public void setArticlesInfo(List<Map<String,String>> articles){
		for(Map<String,String> map : articles){
			Articles arti = new Articles();
			arti.setDescription(map.get("description"));
			arti.setPicUrl(map.get("picUrl"));
			arti.setTitle(map.get("title"));
			arti.setUrl(map.get("url"));
			this.articles.add(arti);
		}
	}
	
	@Setter
	@Getter 
	//@JacksonXmlRootElement(localName = "item")
	private static class Articles{
		
		@JacksonXmlProperty(localName = "Title")
		private String title ;
		
		@JacksonXmlProperty(localName = "Description")
		private String description ;
		
		@JacksonXmlProperty(localName = "PicUrl")
		private String picUrl ;
		
		@JacksonXmlProperty(localName = "Url")
		private String url ;
		
	}

}
