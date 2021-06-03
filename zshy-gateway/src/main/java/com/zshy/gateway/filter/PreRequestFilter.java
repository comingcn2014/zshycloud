package com.zshy.gateway.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import com.zshy.core.cloud.props.ZshyRequestProperties;
import com.zshy.core.common.constant.ZshyConstant;
import com.zshy.core.common.util.UUIDUtil;

/**
 * 给请求增加IP地址和TraceId
 *
 * @author yanghaifeng
 * @since 2020-7-13
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PreRequestFilter implements GlobalFilter, Ordered {

    private final ZshyRequestProperties mateRequestProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 是否开启traceId追踪
        if (mateRequestProperties.getTrace()) {
            // ID生成
            String traceId = UUIDUtil.shortUuid();
            MDC.put(ZshyConstant.LOG_TRACE_ID, traceId);
            ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate()
                    .headers(h -> h.add(ZshyConstant.ZSHY_TRACE_ID, traceId))
                    .build();
            ServerWebExchange build = exchange.mutate().request(serverHttpRequest).build();
            return chain.filter(build);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
