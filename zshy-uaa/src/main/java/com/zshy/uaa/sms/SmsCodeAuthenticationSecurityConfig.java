package com.zshy.uaa.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import com.zshy.core.security.userdetails.ZshyUserDetailsService;

/**
 * 短信验证码登录方式配置
 *
 * @author yanghaifeng
 */
@Component
public class SmsCodeAuthenticationSecurityConfig
		extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	@Autowired
	private ZshyUserDetailsService userDetailsService;

	@Override
	public void configure(HttpSecurity http) {

		// 过滤器
		SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();
		smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));

		// 获取验证码提供者
		SmsCodeAuthenticationProvider smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider(userDetailsService);

		// 将短信验证码校验器注册到 HttpSecurity， 并将短信验证码过滤器添加在 UsernamePasswordAuthenticationFilter 之前
		http.authenticationProvider(smsCodeAuthenticationProvider)
				.addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
