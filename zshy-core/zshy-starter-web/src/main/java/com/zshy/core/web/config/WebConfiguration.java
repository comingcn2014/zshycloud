package com.zshy.core.web.config;

import com.zshy.core.web.listener.RequestMappingScanListener;
import com.zshy.core.web.support.LoginUserArgumentResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.zshy.core.redis.core.RedisService;

import java.util.List;

/**
 * WEB配置类
 *
 * @author yanghaifeng
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {

	private final RedisService redisService;

	/**
	 * Token参数解析
	 *
	 * @param argumentResolvers 解析类
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		//注入用户信息
		argumentResolvers.add(new LoginUserArgumentResolver());
	}

	/**
	 * 资源扫描监听器类
	 *
	 * @return RequestMappingScanListener
	 */
	@Bean
	@ConditionalOnMissingBean(RequestMappingScanListener.class)
	public RequestMappingScanListener resourceAnnotationScan() {
		RequestMappingScanListener scan = new RequestMappingScanListener(redisService);
		log.info("资源扫描类.[{}]", scan);
		return scan;
	}
}
