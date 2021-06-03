package com.zshy.core.auth.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Token属性
 *
 * @author yanghaifeng
 */
@Getter
@Setter
@ConfigurationProperties(TokenProperties.PREFIX)
public class TokenProperties {

	/**
	 * 前缀
	 */
	public static final String PREFIX = "zshy.token.auth";

	/**
	 * 是否开启token验证
	 */
	private Boolean enable = Boolean.TRUE;
}
