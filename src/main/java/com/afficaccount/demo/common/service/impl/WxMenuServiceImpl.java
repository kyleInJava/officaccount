package com.afficaccount.demo.common.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.afficaccount.demo.common.entity.AccessToken;
import com.afficaccount.demo.common.entity.Button;
import com.afficaccount.demo.common.entity.ButtonType;
import com.afficaccount.demo.common.entity.CommonButton;
import com.afficaccount.demo.common.entity.ComplexButton;
import com.afficaccount.demo.common.entity.Menu;
import com.afficaccount.demo.common.entity.ViewButton;
import com.afficaccount.demo.common.service.WxMenuService;


@Service
public class WxMenuServiceImpl implements WxMenuService {
	
	private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	private static final String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=";
	private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ServletContext servletContext;

	@Override
	public String createMenu() {
		
		//第一个按钮是点击按钮
		CommonButton b1 = new CommonButton(ButtonType.CLICK);
		b1.setName("别说话");
		b1.setKey("1");
		
		
		//第二个按钮嵌套了5个小按钮
		ComplexButton b2 = new ComplexButton();
		b2.setName("保持沉默");
		//第一个小按钮
		CommonButton b21 = new CommonButton(ButtonType.CLICK);
		b21.setName("表哥");
		b21.setKey("21");
		//第二个小按钮
		ViewButton b22 = new ViewButton();
		b22.setName("表妹");
		
		String aa = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx202f42d8744a989e&redirect_uri=https://www.baidu.com&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
		b22.setUrl(aa);
		//第三个小按钮
		CommonButton b23 = new CommonButton(ButtonType.SCANCODE_WAITMSG);
		b23.setName("表弟");
		b23.setKey("23");
		//第四个小按钮
		CommonButton b24 = new CommonButton(ButtonType.SCANCODE_PUSH);
		b24.setName("表姐");
		b24.setKey("24");
		//第五个小按钮
		CommonButton b25 = new CommonButton(ButtonType.PIC_SYSPHOTO);
		b25.setName("表姐");
		b25.setKey("25");
		
		List<Button> buttons2 = Arrays.asList(b21,b22,b23,b24,b25);
		b2.setSub_button(buttons2);
		
		
		//第三个按钮嵌套了4个小按钮
		ComplexButton b3 = new ComplexButton();
		b3.setName("我是表哥");
		//第一个小按钮
		CommonButton b31 = new CommonButton(ButtonType.PIC_PHOTO_OR_ALBUM);
		b31.setName("青苹果");
		b31.setKey("31");
		//第二个小按钮
		CommonButton b32 = new CommonButton(ButtonType.PIC_WEIXIN);
		b32.setName("红桔子");
		b32.setKey("32");
		//第三个小按钮
		CommonButton b33 = new CommonButton(ButtonType.LOCATION_SELECT);
		b33.setName("黄香蕉");
		b33.setKey("33");
		//第三个小按钮
		ViewButton b34 = new ViewButton();
		b34.setName("黑桑椹");
		b34.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx202f42d8744a989e&redirect_uri=http://www.baidu.com&response_type=code&scope=snsapi_userinfo&state=321#wechat_redirect");
		List<Button> buttons3 = Arrays.asList(b31,b32,b33,b34);
		b3.setSub_button(buttons3);
		
		
		Menu menu = new Menu();
		List<Button> buttons = Arrays.asList(b1,b2,b3);
		menu.setButton(buttons);
		
		AccessToken token = (AccessToken)servletContext.getAttribute("accessToken");
		return restTemplate.postForObject(CREATE_MENU_URL+token.getAccess_token(), JSON.toJSONString(menu), String.class);
		
	}
	
	
	@Override
	public String getMenu() {
		AccessToken token = (AccessToken)servletContext.getAttribute("accessToken");
		String result = restTemplate.getForObject( GET_MENU_URL+token.getAccess_token(),String.class);
		System.out.println(result);
		return result;
	}
	
	
	@Override
	public String deleteMenu() {
		AccessToken token = (AccessToken)servletContext.getAttribute("accessToken");
		String result =restTemplate.getForObject(DELETE_MENU_URL+token.getAccess_token(),String.class);
		return result;
	}
	
	public static void main(String[] args) {
		new WxMenuServiceImpl().createMenu();
	}


}
