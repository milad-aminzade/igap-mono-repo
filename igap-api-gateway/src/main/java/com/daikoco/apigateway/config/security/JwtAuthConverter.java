package com.daikoco.apigateway.config.security;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class JwtAuthConverter implements Converter<Jwt, Mono<AbstractAuthenticationToken>> {
    private static final String DEFAULT_AUTHORITY_PREFIX = "ROLE_";
    private static final String SUB = "sub";

    private static final Collection<String> WELL_KNOWN_AUTHORITIES_CLAIM_NAMES = Arrays.asList("realm_access", "resource_access");

    private final JwtAuthConverterProperties properties;
    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    public Mono<AbstractAuthenticationToken> convert(@NotNull Jwt jwt) {
        var authorities = Stream.concat(
                jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                extractResourceRoles(jwt)
        );
        return Mono.just(new JwtAuthenticationToken(
                jwt,
                authorities.collect(Collectors.toSet()) ,
                getPrincipleClaimName(jwt)
        ));
    }

    private String getPrincipleClaimName(Jwt jwt) {
        return jwt.getClaim("preferred-username");
    }

    private Stream<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        Map<String,Object> resource;
        Stream<String> resourceRoles;
        if(jwt.getClaim("realm_access") == null)
            return Stream.of();
        resource = jwt.getClaim("realm_access");
        resourceRoles =((List<String>) resource.get("roles")).stream();
        return resourceRoles
                .map(role->new SimpleGrantedAuthority(DEFAULT_AUTHORITY_PREFIX+role));

    }


}
