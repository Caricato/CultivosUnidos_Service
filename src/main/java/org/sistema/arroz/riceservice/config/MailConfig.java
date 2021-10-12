package org.sistema.arroz.riceservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.mail")
public class MailConfig {
    private String host;
    private int port;
    @Value("${spring.mail.username}")
    private String username;
    private String password;
}
