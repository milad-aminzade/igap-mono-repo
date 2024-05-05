package ir.kian.igap.IgapUserProfileChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class IgapUserProfileChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgapUserProfileChallengeApplication.class, args);
	}

}
