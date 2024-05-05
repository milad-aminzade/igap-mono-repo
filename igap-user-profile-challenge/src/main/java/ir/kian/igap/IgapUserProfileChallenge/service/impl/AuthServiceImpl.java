package ir.kian.igap.IgapUserProfileChallenge.service.impl;

import ir.kian.igap.IgapUserProfileChallenge.adapter.KeycloakAdapter;
import ir.kian.igap.IgapUserProfileChallenge.config.properties.KeycloakProperties;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.request.keycloak.KeycloakLoginAdapterRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.response.keycloak.KeycloakLoginAdapterResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.auth.LoginRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.auth.LoginResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.AuthService;
import ir.kian.igap.IgapUserProfileChallenge.transformer.AuthTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final KeycloakAdapter keycloakAdapter;
    private final KeycloakProperties keycloakProperties;

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        KeycloakLoginAdapterRequestDto keycloakLoginAdapterRequestDto = AuthTransformer.toLoginResponse(request, keycloakProperties.getClientId(), keycloakProperties.getClientSecret(), keycloakProperties.getGrantType());
        ResponseEntity<KeycloakLoginAdapterResponseDto> keycloakLoginResponse = keycloakAdapter.login(keycloakLoginAdapterRequestDto);
        return AuthTransformer.toLoginResponseDto(Objects.  requireNonNull(keycloakLoginResponse.getBody()));
    }
}
