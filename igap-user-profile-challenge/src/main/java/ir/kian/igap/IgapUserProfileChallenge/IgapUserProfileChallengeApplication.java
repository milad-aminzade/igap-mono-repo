package ir.kian.igap.IgapUserProfileChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@SpringBootApplication
@Configuration
@EnableCaching
@EnableScheduling
public class IgapUserProfileChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgapUserProfileChallengeApplication.class, args);
    }

}
