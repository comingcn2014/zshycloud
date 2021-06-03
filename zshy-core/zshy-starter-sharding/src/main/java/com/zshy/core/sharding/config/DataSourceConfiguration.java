package com.zshy.core.sharding.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.zshy.core.common.factory.YamlPropertySourceFactory;

@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:zshy-sharding-db.yml")
public class DataSourceConfiguration {
}
