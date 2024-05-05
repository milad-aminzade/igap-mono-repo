package ir.kian.igap.IgapUserProfileChallenge.adapter.fallbacks;

import feign.FeignException;
import ir.kian.igap.IgapUserProfileChallenge.adapter.KeycloakAdapter;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.request.keycloak.KeycloakLoginAdapterRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.response.keycloak.KeycloakLoginAdapterResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.exception.UserNotAllowedException;
import ir.kian.igap.IgapUserProfileChallenge.exception.UserUnAuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

@Slf4j
@Configuration
public class KeycloakFallbackFactory extends BaseFallbackFactory implements FallbackFactory<KeycloakAdapter> {
    @Override
    public KeycloakAdapter create(Throwable cause) {
        return new KeycloakAdapter() {
            @Override
            public ResponseEntity<KeycloakLoginAdapterResponseDto> login(KeycloakLoginAdapterRequestDto request) {
                log.debug("KeycloakUserFallbackFactory:: login -", cause);
                if (cause instanceof FeignException.Forbidden)
                    throw new UserNotAllowedException();
                else if (cause instanceof FeignException.Unauthorized)
                    throw new UserUnAuthorizeException();
                return handle(cause);
            }
        };
    }
}
