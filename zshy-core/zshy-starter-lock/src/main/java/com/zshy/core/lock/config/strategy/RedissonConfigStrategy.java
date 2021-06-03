package com.zshy.core.lock.config.strategy;

import com.zshy.core.lock.props.RedissonProperties;
import org.redisson.config.Config;

/**
 * Redisson配置构建接口
 *
 * @author yanghaifeng
 * @date 2020-10-22
 */
public interface RedissonConfigStrategy {

	/**
	 * 根据不同的Redis配置策略创建对应的Config
	 *
	 * @param redissonProperties redisson配置
	 * @return Config
	 */
	Config createRedissonConfig(RedissonProperties redissonProperties);
}
