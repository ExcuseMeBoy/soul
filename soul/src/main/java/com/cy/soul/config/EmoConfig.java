package com.cy.soul.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "emo")
public class EmoConfig {
    private String filepath;
}
