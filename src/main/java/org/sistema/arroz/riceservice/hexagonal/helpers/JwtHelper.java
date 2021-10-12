package org.sistema.arroz.riceservice.hexagonal.helpers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.sistema.arroz.riceservice.config.JwtConfig;
import org.sistema.arroz.riceservice.hexagonal.HelperAdapter;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;

@HelperAdapter
@RequiredArgsConstructor
public class JwtHelper {

    private final JwtConfig jwtConfig;

    public Claims decode(String jwt) {
        var key = getKey();

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    public String generateToken(String username, Map<String, Object> claims, Long expirationTimeInMinutes) {
        final var key = getKey();
        var createdDate = LocalDateTime.now();
        var expirationDate = createdDate.plusMinutes(expirationTimeInMinutes);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(Date.from(createdDate.toInstant(ZoneOffset.UTC)))
                .setExpiration(Date.from(expirationDate.toInstant(ZoneOffset.UTC)))
                .signWith(key)
                .compact();
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes());
    }
}
