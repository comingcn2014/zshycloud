package com.zshy.core.rocketmq.channel;

import com.zshy.core.rocketmq.constant.MessageConstant;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 生产者Channel
 * 3.0.8+版本不再使用
 *
 * @author yanghaifeng
 */
@Deprecated
public interface ZshySource {

	/**
	 * 短消息通道
	 *
	 * @return MessageChannel
	 */
	@Output(MessageConstant.SMS_MESSAGE_OUTPUT)
	MessageChannel smsOutput();

	/**
	 * 邮件通道
	 *
	 * @return MessageChannel
	 */
	@Output(MessageConstant.EMAIL_MESSAGE_OUTPUT)
	MessageChannel emailOutput();

	/**
	 * 订单通道
	 *
	 * @return MessageChannel
	 */
	@Output(MessageConstant.ORDER_MESSAGE_OUTPUT)
	MessageChannel orderOutput();
}
