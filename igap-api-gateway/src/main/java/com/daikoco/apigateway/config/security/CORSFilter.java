package com.daikoco.apigateway.config.security;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Component
@Getter
@Setter
@Slf4j
public class CORSFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String reqOrigin;
        reqOrigin = request.getHeaders().getOrigin();
        response.getHeaders().setAccessControlAllowOrigin(reqOrigin);
        final HttpHeaders headers = request.getHeaders();
        if (headers.getAccessControlRequestMethod() != null) {
            String reqMethod = headers.getAccessControlRequestMethod().name();
            response.getHeaders().setAccessControlAllowMethods(List.of(HttpMethod.valueOf(reqMethod)));
            response.getHeaders().setAccessControlMaxAge(3600L);
            response.getHeaders().setAccessControlAllowCredentials(true);
            response.getHeaders().setAccessControlAllowHeaders(List.of("cache-control", "if-modified-since,pragma", "Content-Type"));
        }
        if (!response.getHeaders().getAccessControlAllowMethods().isEmpty() && !Objects.requireNonNull(response.getHeaders().getAccessControlAllowOrigin()).isEmpty()) {
            response.setStatusCode(HttpStatus.ACCEPTED);
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -2;
    }

}
