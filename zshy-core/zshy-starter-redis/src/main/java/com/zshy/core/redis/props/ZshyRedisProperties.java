package com.zshy.core.redis.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis配置
 *
 * @author yanghaifeng
 */
@Getter
@Setter
@ConfigurationProperties(ZshyRedisProperties.PREFIX)
public class ZshyRedisProperties {
	/**
	 * 前缀
	 */
	public static final String PREFIX = "zshy.lettuce.redis";
	/**
	 * 是否开启Lettuce
	 */
	private Boolean enable = true;
}
