package com.ssafy.happyhouse.utils;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTUtil {

    private Key key;

    public JWTUtil(String secretKey) {
        key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String createToken(int mid, String name) {

        JwtBuilder jwtBuilder = Jwts.builder()
                                    .claim("mid", mid)
                                    .claim("name", name);

        return jwtBuilder.signWith(key, SignatureAlgorithm.HS256).compact();

    }

    public Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key)
                .parseClaimsJws(token).getBody();
    }
}	