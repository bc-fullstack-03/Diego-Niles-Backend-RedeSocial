package com.sysmap.redesocial.infra.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

@Service
public class JwtService implements IJwtService {

    private final Long EXPIRATION_TIME = 7200000l;
    private final String KEY = "5970337336763979244226452948404D635166546A576E5A7134743777217A25";

    public String generateToken(UUID userId) {
        return Jwts
                .builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(genSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isValidToken(String token, String userId) {
        var sub = getClaim(token, Claims::getSubject);
        var tExpiration = getClaim(token, Claims::getExpiration);

        if(!sub.equals(userId)){
            return false;
        }

        if(tExpiration.before(new Date())){
            return false;
        }

        return true;
    }

    private Key genSigninKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY));
    }

    private <T> T getClaim (String token, Function<Claims, T> claimsResolver){
        var claims = Jwts.parserBuilder().setSigningKey(genSigninKey()).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }
}
