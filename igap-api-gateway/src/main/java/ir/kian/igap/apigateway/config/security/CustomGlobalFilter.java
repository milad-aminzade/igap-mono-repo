package ir.kian.igap.apigateway.config.security;

import ir.kian.igap.apigateway.exception.UserUnAuthorizeException;
import com.nimbusds.jwt.JWTParser;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Getter
@Setter
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    private Jwt jwt;
    private final static String BEARER = "Bearer ";
    private final static String GUEST = "GUEST";
    private final static String USER_HEADER = "username";
    private final static String USERNAME_CLAIM_NAME = "preferred_username";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        List<String> tokenList = exchange.getRequest().getHeaders().get("Authorization");
        if (tokenList == null || tokenList.isEmpty() || StringUtils.isEmpty(tokenList.get(0))) {
            ServerHttpRequest request = exchange.getRequest().mutate().headers(httpHeaders -> {
                httpHeaders.remove(USER_HEADER);
                httpHeaders.add(USER_HEADER, GUEST);
            }).build();
            return chain.filter(exchange.mutate().request(request).build());
        }
        String token = tokenList.get(0);
        token = token.substring(BEARER.length());
        String nationalCode = null;
        try {
            var jwt = JWTParser.parse(token);
            nationalCode = jwt.getJWTClaimsSet().getStringClaim(USERNAME_CLAIM_NAME);
        } catch (Exception exception) {
            return Mono.error(new UserUnAuthorizeException());
        }
        ServerHttpRequest request;
        if (nationalCode != null) {
            String finalNationalCode = nationalCode;
            request =
                    exchange.getRequest().mutate()
                            .headers(headers -> {
                                headers.remove(USER_HEADER);
                                headers.add(USER_HEADER, finalNationalCode);
                            })
                            .build();
        } else
            request = exchange.getRequest().mutate().headers(headers -> {
                headers.remove(USER_HEADER);
                headers.add(USER_HEADER, GUEST);
            }).build();

        ServerHttpResponse response = exchange.getResponse();
        ServerWebExchange mutatedExchange = exchange.mutate().request(request).response(response).build();

        return chain.filter(mutatedExchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
