package ru.ssau.volunteerapi.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.ssau.volunteerapi.model.entitie.Role;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class JwtTokenProvider {
    private final String base64Secret;

    public JwtTokenProvider(@Value("${application.auth.jwt-secret}") String secretKey) {
        this.base64Secret =
                Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(String login, Role role) {
        Claims claims = Jwts.claims().setSubject(login);
        claims.put("role", role.toString());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, base64Secret)
                .compact();
    }

    public JwtUser validateToken(String token) {
        Jwts.parser().setSigningKey(base64Secret).parseClaimsJws(token);
        return new JwtUser(getLogin(token), getRole(token));
    }

    public String getLogin(String token) {
        return Jwts.parser().setSigningKey(base64Secret).parseClaimsJws(token).getBody().getSubject();
    }

    public Role getRole(String token) {
        return (Role) Jwts.parser()
                .setSigningKey(base64Secret)
                .parseClaimsJws(token)
                .getBody().get("role");
    }

}