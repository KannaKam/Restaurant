package com.olgibaba.restaurant.payload.jsonWebToken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWToken {

    private String secretKey = "YQBGw6naxCant7b5b70Vs9tsZiHnGK";
    private long expiration = 999999999;

    public String generateToken(String mail){

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,secretKey)
                .setHeaderParam("Typ", "JWT")
                .setSubject(mail)
                .setExpiration(new Date(new Date().getTime()+expiration))
                .compact();
    }

}
