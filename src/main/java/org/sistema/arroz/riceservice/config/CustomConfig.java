package org.sistema.arroz.riceservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "custom.values")
public class CustomConfig {
    private Boolean sendSMS;
    private Boolean sendMail;
}
