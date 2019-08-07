package com.stiffening.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author wjj
 * @date 2019/8/2
 */
public class RequestTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<RequestTimeGatewayFilterFactory.Config> {

    private static final Logger logger = LoggerFactory.getLogger(GatewayFilter.class);

    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

    private static final String KEY = "withParams";

    public RequestTimeGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                        if (Objects.nonNull(startTime)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(exchange.getRequest().getURI().getRawPath())
                                    .append(":").append(System.currentTimeMillis()-startTime)
                                    .append("ms");
                            if (config.getWithParams()) {
                                stringBuilder.append(",params:").append(exchange.getRequest().getQueryParams());
                            }
                            logger.info(stringBuilder.toString());
                        }
                    })
            );
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(KEY);
    }

    public static class Config{

        private Boolean withParams;

        public Boolean getWithParams() {
            return withParams;
        }

        public Config setWithParams(Boolean withParams) {
            this.withParams = withParams;
            return this;
        }
    }
}
