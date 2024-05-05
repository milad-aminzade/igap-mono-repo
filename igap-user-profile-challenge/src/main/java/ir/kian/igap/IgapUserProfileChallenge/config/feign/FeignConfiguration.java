package ir.kian.igap.IgapUserProfileChallenge.config.feign;

import feign.Feign;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import ir.kian.igap.IgapUserProfileChallenge.config.properties.FeignProperties;
import ir.kian.igap.common.config.properties.FeignClientProperties;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.openfeign.CircuitBreakerNameResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Configuration
public class FeignConfiguration {

    private final FeignProperties feignProperties;

    public FeignConfiguration(FeignProperties feignProperties) {
        this.feignProperties = feignProperties;
    }

    private static void configure(Resilience4JCircuitBreakerFactory resilience4JCircuitBreakerFactory, FeignClientProperties feignClientProperties, String clientName) {
        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(feignClientProperties.getTimeLimit())).build();
        String[] methodSignatures = new String[feignClientProperties.getItems().size()];
        List<String> items = feignClientProperties.getItems().stream().map(methodSign -> clientName + "#" + methodSign).toList();
        methodSignatures = items.toArray(methodSignatures);
        resilience4JCircuitBreakerFactory.configure(builder -> builder.timeLimiterConfig(timeLimiterConfig), methodSignatures);
    }

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> circuitBreakerFactoryCustomizer() {
        return resilience4JCircuitBreakerFactory -> {
            feignProperties.getClientProperties().forEach(
                    (clientName, clientProps)
                            -> FeignConfiguration.configure(resilience4JCircuitBreakerFactory, clientProps, clientName));
        };
    }

    @Bean
    public CircuitBreakerNameResolver circuitBreakerNameResolver() {
        return (feignClientName, target, method) -> Feign.configKey(target.type(), method);
    }


}
