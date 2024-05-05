package ir.kian.igap.IgapUserProfileChallenge.config.properties;

import ir.kian.igap.common.config.properties.BaseProperties;
import ir.kian.igap.common.config.properties.FeignClientProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application.feign.classes")
public class FeignProperties extends BaseProperties {
    private Map<String, FeignClientProperties> clientProperties;
    private String hostName;
}
