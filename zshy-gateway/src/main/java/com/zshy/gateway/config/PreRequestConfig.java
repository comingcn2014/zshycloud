package com.zshy.gateway.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.zshy.core.cloud.props.ZshyRequestProperties;
import com.zshy.core.cloud.props.ZshyApiProperties;

/**
 * 预请求配置
 *
 * @author yanghaifeng
 */
@Configuration
@EnableConfigurationProperties({ZshyRequestProperties.class, ZshyApiProperties.class})
public class PreRequestConfig {
}
