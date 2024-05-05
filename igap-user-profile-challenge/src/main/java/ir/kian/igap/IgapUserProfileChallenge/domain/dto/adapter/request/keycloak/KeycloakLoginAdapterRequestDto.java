package ir.kian.igap.IgapUserProfileChallenge.domain.dto.adapter.request.keycloak;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import ir.kian.igap.common.domain.dto.adapter.request.AdapterRequestDto;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KeycloakLoginAdapterRequestDto extends AdapterRequestDto {
    private String client_id;
    private String client_secret;
    private String username;
    private String password;
    private String grant_type;
}
