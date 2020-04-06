package com.afficaccount.demo.common.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 保存AccessToken
 * @author kyle
 *
 */
@Setter
@Getter
@ToString
public class AccessToken {
	
	private String access_token;
	
	private int expires_in; //有效期（秒）
	
	private long expires; //过期时间
	
	private String errcode; //错误码
	
	private String errmsg; //错误信息
	
	
	
	public void setExpires_in(int expiresIn){
		this.expires_in = expiresIn;
		this.expires = System.currentTimeMillis()+expires_in*81000;
	}

	
	public boolean isExpired(){
		
		if(System.currentTimeMillis() < expires){//过期了
			return true;
		}
		
		return false;
	}

}
