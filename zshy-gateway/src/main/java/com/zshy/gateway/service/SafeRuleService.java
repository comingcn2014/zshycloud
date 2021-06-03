package com.zshy.gateway.service;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 安全规则业务类
 * @author yanghaifeng
 */
public interface SafeRuleService {

    /**
     * 黑名单过滤
     * @param exchange
     * @return
     */
    Mono<Void> filterBlackList(ServerWebExchange exchange);
}
