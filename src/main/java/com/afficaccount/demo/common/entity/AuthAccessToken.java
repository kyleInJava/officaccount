package com.afficaccount.demo.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AuthAccessToken {

	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
}
