package com.zshy.core.seata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.zshy.core.common.factory.YamlPropertySourceFactory;

/**
 * Seata配置
 *
 * @author yanghaifeng
 * @since 1.6.8
 */
@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:zshy-seata.yml")
public class SeataConfiguration {
}
