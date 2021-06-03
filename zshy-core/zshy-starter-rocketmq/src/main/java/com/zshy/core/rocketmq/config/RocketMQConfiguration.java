package com.zshy.core.rocketmq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.zshy.core.common.factory.YamlPropertySourceFactory;

/**
 * RocketMQ配置
 *
 * @author yanghaifeng
 */
@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:zshy-rocketmq.yml")
public class RocketMQConfiguration {
}
