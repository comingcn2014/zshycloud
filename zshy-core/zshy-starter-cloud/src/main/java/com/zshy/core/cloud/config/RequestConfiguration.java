package com.zshy.core.cloud.config;

import com.zshy.core.cloud.filter.TenantContextHolderFilter;
import com.zshy.core.cloud.filter.TraceFilter;
import com.zshy.core.cloud.props.ZshyRequestProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 请求配置，包括tracId和其他网络请求
 * @author yanghaifeng
 */
@Configuration
@EnableConfigurationProperties(ZshyRequestProperties.class)
public class RequestConfiguration {

    @Bean
    public TenantContextHolderFilter tenantContextHolderFilter() {
        return new TenantContextHolderFilter();
    }

    @Bean
    public TraceFilter traceFilter() {
        return new TraceFilter();
    }

}
