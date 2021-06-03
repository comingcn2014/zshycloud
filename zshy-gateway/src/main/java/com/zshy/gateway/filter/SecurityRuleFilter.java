package com.zshy.gateway.filter;

import com.zshy.gateway.service.SafeRuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import com.zshy.core.cloud.props.ZshyRequestProperties;

/**
 * CORS 过滤
 * @author yanghaifeng
 */
@Slf4j
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration(proxyBeanMethods = false)
public class SecurityRuleFilter implements WebFilter {

    private final ZshyRequestProperties mateRequestProperties;
    private final SafeRuleService safeRuleService;

    @Override
    @SuppressWarnings("all")
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        /**
         * 是否开启黑名单
         * 从redis里查询黑名单是否存在
         */
        if (mateRequestProperties.getEnhance()) {
            log.debug("进入黑名单模式");
            // 检查黑名单
            Mono<Void> result = safeRuleService.filterBlackList(exchange);
            if (result != null) {
                return result;
            }
        }
        /**
         * 增加CORS
         * 解决前端登录跨域的问题
         */
        ServerHttpRequest request = exchange.getRequest();
        if (CorsUtils.isCorsRequest(request)) {
            ServerHttpResponse response = exchange.getResponse();
            HttpHeaders headers = response.getHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Methods", "*");
            headers.add("Access-Control-Max-Age", "3600");
            headers.add("Access-Control-Allow-Headers", "*");
            if (request.getMethod() == HttpMethod.OPTIONS) {
                response.setStatusCode(HttpStatus.OK);
                return Mono.empty();
            }
        }
        return chain.filter(exchange);
    }
}
