package com.zshy.core.lock.config.strategy;

import com.zshy.core.lock.constant.GlobalConstant;
import com.zshy.core.lock.props.RedissonProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.config.Config;

/**
 * 集群方式Redisson配置
 *
 * @author yanghaifeng
 * @date 2020-10-22
 */
@Slf4j
public class ClusterRedissonConfigStrategyImpl implements RedissonConfigStrategy {

	@Override
	public Config createRedissonConfig(RedissonProperties redissonProperties) {
		Config config = new Config();
		try {
			String address = redissonProperties.getAddress();
			String password = redissonProperties.getPassword();
			String[] addrTokens = address.split(",");
			// 设置cluster节点的服务IP和端口
			for (int i = 0; i < addrTokens.length; i++) {
				config.useClusterServers()
						.addNodeAddress(GlobalConstant.REDIS_CONNECTION_PREFIX.getConstant_value() + addrTokens[i]);
				if (StringUtils.isNotBlank(password)) {
					config.useClusterServers().setPassword(password);
				}
			}
			log.info("初始化[cluster]方式Config,redisAddress:" + address);
		} catch (Exception e) {
			log.error("cluster Redisson init error", e);
			e.printStackTrace();
		}
		return config;
	}
}
