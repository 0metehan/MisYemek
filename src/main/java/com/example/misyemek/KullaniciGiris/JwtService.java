package com.example.misyemek.KullaniciGiris;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.access-expiration}")
    private long accessExpiration;

    @Value("${jwt.refresh-expiration}")
    private long refreshExpiration;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String buildToken(String username, String rol, long expiration) {
        return Jwts.builder()
                .subject(username)
                .claim("rol", rol)
                .issuedAt(new Date())  //üretilme zamanı
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey())
                .compact();
    }
    public String generateAccessToken(String username , String rol){
        return buildToken(username ,rol ,accessExpiration);
    }

    public String generateRefreshToken(String username){
        return buildToken(username ,null ,refreshExpiration);
    }

    private Claims readToken(String token) {
        return Jwts.parser()   //token okuyucu
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token) {
        return readToken(token).getSubject();
    }

    public String extractRol(String token) {
        return readToken(token).get("rol", String.class);
    }

    public boolean isTokenValid(String token) {
        try {
            Date expiry = readToken(token).getExpiration();
            return expiry.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}