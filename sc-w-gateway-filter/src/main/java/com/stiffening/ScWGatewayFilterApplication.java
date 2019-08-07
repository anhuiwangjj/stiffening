package com.stiffening;

import com.stiffening.component.HostAddrKeyResolver;
import com.stiffening.filter.RequestTimeFilter;
import com.stiffening.filter.RequestTimeGatewayFilterFactory;
import com.stiffening.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScWGatewayFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScWGatewayFilterApplication.class, args);
    }

   /* @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/consumer/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addRequestHeader("X-Response-default-Foo","Default-Foo"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("custom-filter-route"))
                .build();
    }*/

   /*@Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
       return new RequestTimeGatewayFilterFactory();
   }*/

//   @Bean
//   public TokenFilter tokenFilter() {
//       return new TokenFilter();
//   }

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
}
