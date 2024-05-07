package ir.kian.igap.IgapUserProfileChallenge.config.properties;

import ir.kian.igap.common.config.properties.BaseProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "app.config.keycloak")
public class KeycloakProperties extends BaseProperties {
    private String url;
    private String realm;
    private String clientId;
    private String clientSecret;
    private String grantType;
}
