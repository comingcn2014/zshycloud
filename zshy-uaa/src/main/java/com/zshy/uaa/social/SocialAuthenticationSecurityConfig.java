package com.zshy.uaa.social;

import com.xkcoding.justauth.AuthRequestFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import com.zshy.core.security.userdetails.ZshyUserDetailsService;

/**
 * 社交登录配置
 *
 * @author yanghaifeng
 */
@Slf4j
@Component
public class SocialAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	@Autowired
	private ZshyUserDetailsService userDetailsService;

	@Autowired
	private AuthRequestFactory authRequestFactory;

	@Override
	public void configure(HttpSecurity http) {

		// 过滤器
		SocialAuthenticationFilter socialAuthenticationFilter = new SocialAuthenticationFilter();
		socialAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
		socialAuthenticationFilter.setAuthRequestFactory(authRequestFactory);


		// 获取社交登录提供者
		SocialAuthenticationProvider socialAuthenticationProvider = new SocialAuthenticationProvider(userDetailsService);

		// 将社交登录校验器注册到 HttpSecurity， 并将社交登录过滤器添加在 UsernamePasswordAuthenticationFilter 之前
		http.authenticationProvider(socialAuthenticationProvider)
				.addFilterBefore(socialAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
