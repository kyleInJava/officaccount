package com.afficaccount.demo.common.service.impl;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afficaccount.demo.common.entity.AccessToken;
import com.afficaccount.demo.common.service.QrCodeService;

@Service
public class QrCodeServiceImpl implements QrCodeService {
	
	
	private static final String QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public String getPermanentQrCode() {
		AccessToken token = (AccessToken)servletContext.getAttribute("accessToken");
		String data = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\":\"永久二维码\"}}}";
		return restTemplate.postForObject(QRCODE_URL+token.getAccess_token(), data, String.class);
	}

	@Override
	public String getTemporaryQrCode() {
		AccessToken token = (AccessToken)servletContext.getAttribute("accessToken");
		String data = "{\"expire_seconds\":604800, \"action_name\":\"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\":\"临时二维码\"}}}";
		return restTemplate.postForObject(QRCODE_URL+token.getAccess_token(), data, String.class);
	}
	
}
