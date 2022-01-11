package com.nhn.nhnsoft.jobray.gateway.routes;

import com.nhn.nhnsoft.jobray.gateway.common.properties.RoutesProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * <h1>commerce 서비스 라우팅 설정</h1>
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CommerceRoutes {

    private final RoutesProperties routesProperties;

    @Bean
    public RouteLocator commerceRoutesLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            /*
             * path 기반 요청 시 라우팅 설정
             * http://게이트웨이도메인/라우팅path/실제요청path 요청 시 아래 설정으로 라우팅을 수행합니다.
             * http://게이트웨이도메인/라우팅path/실제요청path => http://커머스서비스/실제요청path
             */
            .route(p -> p.path(routesProperties.getCommercePath())
                .filters(f -> f.stripPrefix(routesProperties.getCommerceStripSize()))
                .uri(routesProperties.getCommerceUrl()))
            /*
             * host 기반 요청 시 라우팅 설정
             * http://라우팅도메인/실제요청path 요청 시 아래 설정으로 라우팅을 수행합니다.
             * http://라우팅도메인/실제요청path => http://커머스서비스/실제요청path
             */
            .route(p -> p.host(routesProperties.getCommerceHost())
                .uri(routesProperties.getCommerceUrl()))
            .build();
    }
}
