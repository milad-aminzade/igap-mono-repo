package ir.kian.igap.IgapUserProfileChallenge.transformer;


import ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.request.keycloak.KeycloakLoginAdapterRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.response.keycloak.KeycloakLoginAdapterResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.auth.LoginRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.auth.LoginResponseDto;

public class AuthTransformer {
    public static KeycloakLoginAdapterRequestDto toLoginResponse(LoginRequestDto loginRequestDto, String clientId, String clientSecret, String grantType) {
        return KeycloakLoginAdapterRequestDto.builder()
                .username(loginRequestDto.getUsername())
                .password(loginRequestDto.getPassword())
                .client_id(clientId)
                .client_secret(clientSecret)
                .grant_type(grantType)
                .build();
    }

    public static LoginResponseDto toLoginResponseDto(KeycloakLoginAdapterResponseDto responseDto){
        return LoginResponseDto.builder()
                .accessToken(responseDto.getAccessToken())
                .expireIn(responseDto.getExpireIn())
                .refreshExpiresIn(responseDto.getRefreshExpiresIn())
                .refreshToken(responseDto.getRefreshToken())
                .build();

    }
}
