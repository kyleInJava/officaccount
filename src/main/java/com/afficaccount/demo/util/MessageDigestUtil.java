package com.afficaccount.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 消息摘要工具类
 * @author kyle
 */
public class MessageDigestUtil {
	
	private static final char[] CHARS = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

	/**
	 * 对字符串进行散列
	 * @param src  源字符串
	 * @param algorithm
	 * @return
	 */
	public static String digest(String src, String algorithm){
		
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] digest = md.digest(src.getBytes());
			StringBuilder sb = new StringBuilder();
			
			for(byte b : digest){//将byte的高4位和低4位分别转换为16进制字符，然后拼接
				sb.append(CHARS[(b >> 4)&15]);
				sb.append(CHARS[b&15]);
			}
			
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 采用sha1散列算法加密
	 * @param src
	 * @return
	 */
	public static String sha1(String src){
		return digest(src, "sha1");
	}
}
