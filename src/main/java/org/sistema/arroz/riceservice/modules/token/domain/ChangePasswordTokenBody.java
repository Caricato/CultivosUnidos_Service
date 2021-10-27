package org.sistema.arroz.riceservice.modules.token.domain;

import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
public class ChangePasswordTokenBody {
    String email;
    String username;

    public Map<String, Object> map() {
        var map = new HashMap<String, Object>();
        map.put("email", email);
        map.put("username", username);
        return map;
    }
}
