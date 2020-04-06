package com.afficaccount.demo.common.service;

import com.afficaccount.demo.common.entity.AuthAccessToken;

public interface WebPageAuthorizationService {

	AuthAccessToken getAccessToken(String code, String state);

	String getAuthorizationInfo(AuthAccessToken token);

}
