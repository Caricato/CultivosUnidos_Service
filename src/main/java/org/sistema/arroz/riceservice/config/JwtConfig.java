package org.sistema.arroz.riceservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter @Setter
@ConfigurationProperties(prefix = "security.jwt")
public class JwtConfig {
    private String secret;
    private Login login;
    private ResetPassword resetPassword;

    @Getter @Setter
    public static class Login {
        private Long expirationInMinutes;
    }

    @Getter @Setter
    public static class ResetPassword {
        private Long expirationInMinutes;
    }
}

