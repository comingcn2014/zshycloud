package com.zshy.core.rule.config;

import com.zshy.core.rule.service.IRuleCacheService;
import com.zshy.core.rule.service.impl.RuleCacheServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 规则配置
 * @author yanghaifeng
 */
@Configuration
public class RuleConfiguration {

    @Bean
    public IRuleCacheService ruleCacheService() {
        return new RuleCacheServiceImpl();
    }
}
