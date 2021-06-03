package com.zshy.core.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.zshy.core.common.factory.YamlPropertySourceFactory;

/**
 * 统一异常处理配置
 * @author yanghaifeng
 */
@Configuration
@ComponentScan(value="com.zshy.core.web.handler")
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:zshy-error.yml")
public class ExceptionConfiguration {
}