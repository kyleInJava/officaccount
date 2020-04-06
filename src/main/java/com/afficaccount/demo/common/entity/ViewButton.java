package com.afficaccount.demo.common.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewButton extends Button {

	private String type;
	
	private String url;

	public ViewButton(){
		this.type = ButtonType.VIEW;
	}
	
}