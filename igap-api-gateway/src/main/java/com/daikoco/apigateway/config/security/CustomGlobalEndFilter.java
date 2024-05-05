package com.daikoco.apigateway.config.security;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Getter
@Setter
@Slf4j
public class CustomGlobalEndFilter implements GlobalFilter, Ordered {

    private Jwt jwt;
    private final static String BEARER = "Bearer ";
    private final static String GUEST = "GUEST";
    private final static String USER_HEADER = "username";
    private final static String USERNAME_CLAIM_NAME = "preferred_username";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();
        ServerWebExchange mutatedExchange = exchange.mutate().request(exchange.getRequest()).response(response).build();
        return chain.filter(mutatedExchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
