package ir.kian.igap.IgapUserProfileChallenge.adapter;

import ir.kian.igap.IgapUserProfileChallenge.adapter.fallbacks.KeycloakFallbackFactory;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.request.keycloak.KeycloakLoginAdapterRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.response.keycloak.KeycloakLoginAdapterResponseDto;
import ir.kian.igap.common.adapter.BaseAdapter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "KeycloakAdapter", url = "${app.config.keycloak.url}", fallbackFactory = KeycloakFallbackFactory.class)
public interface KeycloakAdapter extends BaseAdapter {
    @RequestMapping(method = RequestMethod.POST, value = "/realms/${app.config.keycloak.realm}/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ResponseEntity<KeycloakLoginAdapterResponseDto> login(@RequestBody KeycloakLoginAdapterRequestDto request);
}
