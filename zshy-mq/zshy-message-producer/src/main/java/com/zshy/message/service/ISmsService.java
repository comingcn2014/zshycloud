package com.zshy.message.service;

/**
 * 发送短消息业务类
 *
 * @author yanghaifeng
 */
public interface ISmsService {

	/**
	 * 发送短消息
	 *
	 * @param message 　短消息
	 */
	void sendSms(String message);
}
