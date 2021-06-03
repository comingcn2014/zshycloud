package com.zshy.core.encrypt.handler;

/**
 * 加密业务接口
 *
 * @author gaoyang
 */
public interface EncryptHandler {

	/**
	 * 加密
	 *
	 * @param content 加密内容
	 * @return 　　　　byte数组
	 */
	byte[] encode(byte[] content);

	/**
	 * 解密
	 *
	 * @param content 加密内容
	 * @return byte数组
	 */
	byte[] decode(byte[] content);
}
