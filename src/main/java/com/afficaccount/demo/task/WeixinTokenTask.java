package com.afficaccount.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.afficaccount.demo.common.service.AccessTokenService;

@Component
@EnableScheduling
public class WeixinTokenTask {
	
	@Autowired
	private AccessTokenService accessTokenService;
	
	/**
	 * 定时刷新微信公众号token,100分钟刷新一次，启动后立刻执行
	 */
	@Scheduled(fixedRate=100*60*1000)
    public void refreshAccessToken(){
		accessTokenService.getAccessToken();
    }

}
