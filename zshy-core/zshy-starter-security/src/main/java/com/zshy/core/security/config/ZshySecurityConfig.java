package com.zshy.core.security.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

/**
 * 安全配置
 *
 * @author yanghaifeng
 */
@Order(6)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ConditionalOnProperty(value = "zshy.security.enable", havingValue = "true", matchIfMissing = true)
public class ZshySecurityConfig extends GlobalMethodSecurityConfiguration {

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		return new OAuth2MethodSecurityExpressionHandler();
	}
}
