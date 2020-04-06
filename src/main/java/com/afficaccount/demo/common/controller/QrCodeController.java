package com.afficaccount.demo.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afficaccount.demo.common.service.QrCodeService;

/**
 * 获取微信公众号对应的二维码
 * @author kyle
 *
 */
@RestController
@RequestMapping("qrcode")
public class QrCodeController {
	
	@Autowired
	private QrCodeService qrCodeService;
	
	
	/**
	 * 获取永久的二维码
	 * @return
	 */
	@RequestMapping("permanet")
	public String getPermanentQrCode(){
		return qrCodeService.getPermanentQrCode();
	}
	
	/**
	 * 获取临时二维码
	 * @return
	 */
	@RequestMapping("temporary")
	public String getTemporaryQrCode(){
		return qrCodeService.getTemporaryQrCode();
	}
	

}
