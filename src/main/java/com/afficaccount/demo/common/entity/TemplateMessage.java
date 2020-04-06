package com.afficaccount.demo.common.entity;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateMessage {

	private String touser;
	
	private String template_id;
	
	private String url;
	
	private Map<String,Map<String,String>> data;
	
	
}
