package com.zshy.uaa.service;

import com.zshy.core.common.api.Result;
import com.zshy.core.common.exception.CaptchaException;

/**
 * 验证码业务类
 *
 * @author yanghaifeng
 */
public interface ValidateService {


	/**
	 * 获取验证码
	 *
	 * @return Result
	 */
	Result<?> getCode();

	/**
	 * 获取短信验证码
	 *
	 * @param mobile 手机号码
	 * @return Result
	 */
	Result<?> getSmsCode(String mobile);

	/**
	 * 校验验证码
	 *
	 * @param key  　KEY
	 * @param code 验证码
	 * @throws CaptchaException 验证码异常
	 */
	void check(String key, String code) throws CaptchaException;
}
