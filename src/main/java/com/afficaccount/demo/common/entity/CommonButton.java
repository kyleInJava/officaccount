package com.afficaccount.demo.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 公共button，主要是以下几种
 *  click：点击该按钮，微信服务器会推送事件给开发者
	scancode_waitmsg：调用扫一扫工具，将扫描的结果传给开发者，同时弹出"消息接受中"的提示
	scancode_push：调用扫一扫工具，将扫描的结果传给开发者
	pic_sysphoto:调用拍照，将照片传给开发者，并推送事件给开发者
	pic_photo_or_album：调用拍照或者相册选择图片
	pic_weixin：弹出微信相册，选择图片发送给开发者
	location_select：弹出地理位置选择
	
	
 * @author kyle
 *
 */
@Getter
@Setter
public class CommonButton extends Button {

	private String type;
	
	private String key;
	
	/**
	 * 为Button设置type
	 * @param type
	 */
	public CommonButton(String type){
		this.type = type;
	}
	
	
	
}
