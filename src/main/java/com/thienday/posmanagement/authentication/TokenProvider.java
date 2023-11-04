package com.thienday.posmanagement.authentication;

import com.thienday.posmanagement.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class TokenProvider {
    private final String JWT_SECRET = System.getenv("jwt_secret");
    private final long JWT_EXPIRATION = 2*3600*1000;

    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder().setAudience(user.getUserName())
                .setSubject(user.getPassword())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
    }

    public String getUserNameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return (String) claims.getAudience();
    }

    public String getPasswordFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return (String) claims.getSubject();
    }


    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid token");
        } catch (ExpiredJwtException ex) {
            log.error("Token Expired");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported token");
        } catch (IllegalArgumentException ex) {
            log.error("Hmmmm argument failed.");
        }
        return false;
    }
}
