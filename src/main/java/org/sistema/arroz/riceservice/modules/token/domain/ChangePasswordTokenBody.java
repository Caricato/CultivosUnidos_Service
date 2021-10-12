package org.sistema.arroz.riceservice.modules.token.domain;

import lombok.Value;

import java.util.Map;

@Value
public class ChangePasswordTokenBody {
    String email;
    String username;

    public Map<String, Object> map() {
        return Map.of("email", email, "username", username);
    }
}
