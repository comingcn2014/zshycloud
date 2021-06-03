package com.zshy.core.retrofit.config;

import com.zshy.core.retrofit.interceptor.SignInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.zshy.core.common.factory.YamlPropertySourceFactory;

/**
 * Retrofit配置类
 *
 * @author yanghaifeng
 */
@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:zshy-retrofit.yml")
public class RetrofitConfiguration {

	@Bean
	public SignInterceptor signInterceptor() {
		return new SignInterceptor();
	}

}
