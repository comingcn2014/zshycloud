package com.zshy.core.auth.util;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.zshy.core.common.entity.LoginUser;

/**
 * 安全服务工具类
 *
 * @author yanghaifeng
 */
@UtilityClass
public class ZshyAuthUser {

	/**
	 * 获取Authentication
	 */
	private Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取用户
	 */
	public LoginUser getUser() {
		Authentication authentication = getAuthentication();
		return getUser(authentication);
	}


	/**
	 * 获取用户
	 *
	 * @param authentication 用户认证
	 * @return 登录用户
	 */
	public LoginUser getUser(Authentication authentication) {
		Object principal = authentication.getPrincipal();
		if (principal instanceof LoginUser) {
			return (LoginUser) principal;
		}
		return null;
	}

	/**
	 * 获取用户名称
	 *
	 * @return username
	 */
	public String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		return authentication.getName();
	}
}
