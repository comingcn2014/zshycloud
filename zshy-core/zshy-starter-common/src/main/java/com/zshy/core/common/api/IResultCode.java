package com.zshy.core.common.api;

/**
 * 返回码接口
 *
 * @author yanghaifeng
 */
public interface IResultCode {

	/**
	 * 返回码
	 *
	 * @return int
	 */
	int getCode();

	/**
	 * 返回消息
	 *
	 * @return String
	 */
	String getMsg();
}
