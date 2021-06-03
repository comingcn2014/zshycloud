/*
 * Copyright 2019-2028 Beijing Daotiandi Technology Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Author: yanghaifeng (694939483@qq.com)
 */
package com.zshy.uaa.config;

import com.zshy.uaa.service.impl.UserDetailsServiceImpl;
import com.zshy.uaa.social.SocialAuthenticationSecurityConfig;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.zshy.core.security.config.IgnoreUrlPropsConfiguration;
import com.zshy.core.security.handle.ZshyAuthenticationFailureHandler;
import com.zshy.core.security.handle.ZshyAuthenticationSuccessHandler;
import com.zshy.uaa.sms.SmsCodeAuthenticationSecurityConfig;

import javax.annotation.Resource;

/**
 * 安全配置中心
 *
 * @author yanghaifeng
 * @date 2019-10-11 23:25
 **/
@Order(3)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private IgnoreUrlPropsConfiguration ignoreUrlPropsConfig;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Resource
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

	@Resource
	private SocialAuthenticationSecurityConfig socialAuthenticationSecurityConfig;

	/**
	 * 必须要定义，否则不支持grant_type=password模式
	 *
	 * @return AuthenticationManager
	 */
	@Bean
	@Override
	@SneakyThrows
	public AuthenticationManager authenticationManagerBean() {
		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationSuccessHandler mateAuthenticationSuccessHandler() {
		return new ZshyAuthenticationSuccessHandler();
	}

	@Bean
	public AuthenticationFailureHandler mateAuthenticationFailureHandler() {
		return new ZshyAuthenticationFailureHandler();
	}

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config
				= http.requestMatchers().anyRequest()
				.and()
				.formLogin()
				.and()
				.apply(smsCodeAuthenticationSecurityConfig)
				.and()
				.apply(socialAuthenticationSecurityConfig)
				.and()
				.authorizeRequests();
		ignoreUrlPropsConfig.getUrls().forEach(url -> {
			config.antMatchers(url).permitAll();
		});
		ignoreUrlPropsConfig.getIgnoreSecurity().forEach(url -> {
			config.antMatchers(url).permitAll();
		});
		config
				//任何请求
				.anyRequest()
				//都需要身份认证
				.authenticated()
				//csrf跨站请求
				.and()
				.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
				userDetailsService(userDetailsService())
				.passwordEncoder(passwordEncoder());
	}
}
