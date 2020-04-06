package com.afficaccount.demo.common.service.impl;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.afficaccount.demo.common.entity.BaseMessage;
import com.afficaccount.demo.common.entity.TextMessage;
import com.afficaccount.demo.common.service.MessageAndEventService;

/**
 * 接收并处理普通消息和事件
 * @author kyle
 */
@Service
public class MessageAndEventServiceImpl  implements MessageAndEventService{
	
	/**
	 * 处理消息和事件
	 * @param requestMap
	 * @return
	 */
	public BaseMessage handle(Map<String, String> requestMap){
		
		switch(requestMap.get("MsgType")){
			
			case "text" :
				return handleTextMessage(requestMap);
			case "image" :
				return handleImageMessage(requestMap);
			case "voice" :
				return handleVoiceMessage(requestMap);
			case "video" :
				return handleVideoMessage(requestMap);
			case "shortvideo" :
				return handleShortVideoMessage(requestMap);
			case "location" :
				return handleLocationMessage(requestMap);
			case "link" :
				return handleLinkMessage(requestMap);
			case "event" :
				return handleEvent(requestMap);
			default :
				return null;
		}
		
	}
	
	/**
	 * 处理各种事件
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleEvent(Map<String, String> requestMap) {
		
		switch(requestMap.get("Event")){
		
			case "subscribe" :
				return handleSubscribeEvent(requestMap);
			case "unsubscribe" :
				return handleUnsubscribeEvent(requestMap);
			case "SCAN" :
				return handleScanEvent(requestMap);
			case "LOCATION" :
				return handleLocationEvent(requestMap);
			case "CLICK" :
				return handleClickEvent(requestMap);
			case "VIEW" :
				return handleViewEvent(requestMap);
			default :
				return null;
		}

	}


	/**
	 * 处理文本消息
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleTextMessage(Map<String, String> requestMap) {
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("收到了你的文本消息");
		
		return tm;
	}
	
	/**
	 * 处理图片消息
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleImageMessage(Map<String, String> requestMap) {
//		ImageMessage im = new ImageMessage();
//		im.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
//		im.setFromUserName("gh_bfb6f5813bde");
//		im.setCreateTime(1585981901);
//		im.setImageInfo("http://mmbiz.qpic.cn/mmbiz_jpg/3hMPU4dbnuptePuvOErmck7dcGNLk7aPRWFVhIgqoLPKDA4IGbro2uokwwMGUZJ5Kzb6PTFlyxQeEHESoMGaVQ/0");
//		return im;
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("收到了你的图片消息");
		
		return tm;
	}
	
	/**
	 * 处理语音消息
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleVoiceMessage(Map<String, String> requestMap) {

//		VoiceMessage vom = new VoiceMessage();
//		vom.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
//		vom.setFromUserName("gh_bfb6f5813bde");
//		vom.setCreateTime(1585981901);
//		vom.setVoiceInfo("cCMnLfhZuSF9IWX31fjLu4tq31Xhqc7JHsMGoiAqqGiEPyMlF9hDKCxWMFTbolF4");
//		return vom;
		
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("收到了你的语音消息");
		
		return tm;
		
	}
	
	/**
	 * 处理视频消息
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleVideoMessage(Map<String, String> requestMap) {
		
//		VideoMessage vm = new VideoMessage();
//		vm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
//		vm.setFromUserName("gh_bfb6f5813bde");
//		vm.setCreateTime(1585981901);
//		vm.setVideoInfo("TGGRbtcHFcxgHf-0P6bXYqU-IPFYUA6q1nmkkUdpiDOFA4OV-JxlBXBsPJNIsetd","视频标题","视频描述");
//		return vm;
		
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("收到了你的视频消息");
		
		return tm;
		
	}
	
	
	/**
	 * 处理小视频消息
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleShortVideoMessage(Map<String, String> requestMap) {
		
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("收到了你的短视频消息");
		
		return tm;
	}
	
	
	/**
	 * 处理地理位置消息
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleLocationMessage(Map<String, String> requestMap) {
//		MusicMessage mm = new MusicMessage();
//		mm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
//		mm.setFromUserName("gh_bfb6f5813bde");
//		mm.setCreateTime(1585981901);
//		mm.setMusicInfo("titleXXXX","descriptionXXX","musiceUrl.....","hqmusicUrl...","thumbMediaId.....");
//		return null;
		
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("收到了你的定位消息");
		
		return tm;
	}

	
	/**
	 * 处理链接消息
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleLinkMessage(Map<String, String> requestMap) {

//		List<Map<String,String>> list = new ArrayList<>();
//		Map<String,String> map = new HashMap<>();
//		map.put("description", "这是图片的描述");
//		map.put("picUrl", "http://mmbiz.qpic.cn/mmbiz_jpg/3hMPU4dbnuptePuvOErmck7dcGNLk7aPRWFVhIgqoLPKDA4IGbro2uokwwMGUZJ5Kzb6PTFlyxQeEHESoMGaVQ/0");
//		map.put("title", "这是图片的标题");
//		map.put("url", "www.baidu.com");
//		list.add(map);
//		
//		ArticlesMessage am = new ArticlesMessage();
//		am.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
//		am.setFromUserName("gh_bfb6f5813bde");
//		am.setCreateTime(1585981901);
//		am.setArticleCount(1);
//		am.setArticlesInfo(list);
//		return am;
		
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("收到了你的文本消息");
		
		return tm;
	}
	
	
	/**
	 * 处理关注事件
	 * 如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleSubscribeEvent(Map<String, String> requestMap) {
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("感谢你关注了我");
		
		return tm;
	}

	/**
	 * 处理取消关注事件
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleUnsubscribeEvent(Map<String, String> requestMap) {
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("不要去要关注");
		
		return tm;
	}

	/**
	 * 如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleScanEvent(Map<String, String> requestMap) {
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。");
		
		return tm;
	}

	/**
	 * 处理上报地址事件
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleLocationEvent(Map<String, String> requestMap) {
		TextMessage tm = new TextMessage();
		tm.setToUserName("od_GVt9DYNRBm2Dl3QC2_hS9g0vo");
		tm.setFromUserName("gh_bfb6f5813bde");
		tm.setCreateTime(1585979580);
		tm.setContent("处理上报地址事件");
		
		return tm;
	}

	/**
	 * 点击自定义菜单事件
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleClickEvent(Map<String, String> requestMap) {
		
		return null;
	}

	/**
	 * 点击菜单跳转链接时的事件推送
	 * @param requestMap
	 * @return
	 */
	private BaseMessage handleViewEvent(Map<String, String> requestMap) {
		return null;
	}

	

}
