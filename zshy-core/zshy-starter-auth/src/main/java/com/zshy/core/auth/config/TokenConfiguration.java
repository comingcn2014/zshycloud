package com.zshy.core.auth.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.zshy.core.auth.props.TokenProperties;

/**
 * Token配置
 *
 * @author yanghaifeng
 */
@Configuration
@ComponentScan(value = "com.zshy.core.auth")
@EnableConfigurationProperties(TokenProperties.class)
@ConditionalOnProperty(value = TokenProperties.PREFIX + ".enabled", havingValue = "true", matchIfMissing = true)
public class TokenConfiguration {

}
