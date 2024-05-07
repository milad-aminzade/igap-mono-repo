package com.daikoco.daikocoserviceregisetery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class IgspServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgspServiceDiscoveryApplication.class, args);
    }

}
