package com.stiffening.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author wjj
 * @date 2019/8/2
 */
public class RequestTimeFilter implements GatewayFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(GatewayFilter.class);
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(REQUEST_TIME_BEGIN,System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() ->{
            Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
            if (Objects.nonNull(startTime)) {
                log.info(exchange.getRequest().getURI().getRawPath()+ ":" +(System.currentTimeMillis()-startTime)+ "ms");
            }
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
