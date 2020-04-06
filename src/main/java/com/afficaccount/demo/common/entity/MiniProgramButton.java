package com.afficaccount.demo.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 跳转小程序的button
 * @author kyle
 *
 */

@Getter
@Setter
public class MiniProgramButton extends Button {

	
	private String type;
	
	private String url;
	
	private String appid;
	
	private String pagepath;
	
	
	public MiniProgramButton(String type){
		this.type = ButtonType.MINIPROGRAM;
	}
}
