package com.zshy.core.kafka.config;

import org.springframework.context.annotation.PropertySource;
import com.zshy.core.common.factory.YamlPropertySourceFactory;

@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:zshy-kafka.yml")
public class KafkaConfiguration {
}
