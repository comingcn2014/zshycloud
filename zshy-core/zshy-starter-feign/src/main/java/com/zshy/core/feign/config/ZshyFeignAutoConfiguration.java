package com.zshy.core.feign.config;

import feign.Feign;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.ZshyFeignClientsRegistrar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.zshy.core.feign.endpoint.FeignClientEndpoint;

/**
 * Feign配置类
 *
 * @author yanghaifeng
 */
@Configuration
@ConditionalOnClass(Feign.class)
@Import(ZshyFeignClientsRegistrar.class)
@AutoConfigureAfter(EnableFeignClients.class)
public class ZshyFeignAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnAvailableEndpoint
    public FeignClientEndpoint feignClientEndpoint(ApplicationContext context) {
        return new FeignClientEndpoint(context);
    }

//    @Bean
//    @Primary
//    public ZshyHystrixTargeter mateFeignTargeter() {
//        return new ZshyHystrixTargeter();
//    }
}
