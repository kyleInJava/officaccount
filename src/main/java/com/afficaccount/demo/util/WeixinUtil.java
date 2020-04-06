package com.afficaccount.demo.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 微信服务器通信相关的工具类
 * @author kyle
 */
public class WeixinUtil {
	
	private static final String Token = "kyleinjava";
	
	/**
	 * 校验信息是否来自微信服务器
	 * 1.将token、timestamp、nonce三个参数进行字典序排序 
	 * 2.将三个参数字符串拼接成一个字符串进行sha1加密
	 * 3.开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
	 * @param signature  微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp  时间戳
	 * @param nonce		  随机数
	 * 
	 * @return
	 */
	public static boolean checkMessageSource(String signature, String timestamp, String nonce){
		
		String[] strs = new String[]{Token,timestamp,nonce};
		Arrays.sort(strs);
		String str = strs[0]+strs[1]+strs[2];
		String digest = MessageDigestUtil.sha1(str);
		if(signature.equals(digest)){//如果相同，说明校验成功
			return true;
		}
		
		return false;
	}
	
	/**
	 * 将微信后台发给应用的xml解析为Map对象
	 * @param request
	 * @return
	 */
	public static Map<String,String> parseXml(HttpServletRequest request){
		Map<String,String> map = new HashMap<>();
		SAXReader reader = new SAXReader();
		ServletInputStream inputStream;
		try {
			inputStream = request.getInputStream();
			Document document = reader.read(inputStream);
			Element root = document.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> children = root.elements();
			for(Element e : children){
				map.put(e.getName(), e.getText());
			}
			
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
		return map;
		
	}
	

}
