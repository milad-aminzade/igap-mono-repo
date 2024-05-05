package ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.response.keycloak;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.kian.igap.common.domain.dto.adapter.response.AdapterResponseDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeycloakLoginAdapterResponseDto extends AdapterResponseDto {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Long expireIn;
    @JsonProperty("refresh_expires_in")
    private Long refreshExpiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("not-before-policy")
    private Long notBeforePolicy;
    @JsonProperty("session_state")
    private String sessionState;
    @JsonProperty("scope")
    private String scope;
}
