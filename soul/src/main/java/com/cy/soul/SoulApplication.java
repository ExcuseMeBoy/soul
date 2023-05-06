package com.cy.soul;

import com.cy.soul.config.EmoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EmoConfig.class)
public class SoulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoulApplication.class, args);
    }

}
