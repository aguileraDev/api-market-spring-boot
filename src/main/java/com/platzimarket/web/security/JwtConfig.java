package com.platzimarket.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @author aguileradev
 */
@Component
public class JwtConfig {

    private static final String KEY = "asdfSFS34WfsdfsHfSDSx32dTsddDDerQSNCK34SOWEK5354fdgdf4";

    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(KEY),
            SignatureAlgorithm.HS256.getJcaName());
    public String generateToken(UserDetails user){
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +1000 *60 *60 *10))
                .signWith(hmacKey)
                .compact();
    }
    public Jws<Claims> getClaims(String token){
       return Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(token);


    }
    public String extractTokenUserName(Jws<Claims> jwsToken){
        return jwsToken.getBody().getSubject();
    }
    public boolean isTokenExpired(Jws<Claims> jwsToken){
        return jwsToken.getBody().getExpiration().before(new Date());
    }

    public boolean validateToken(Jws<Claims> jwsToken, UserDetails userDetails){
        String apiUserName = userDetails.getUsername();

        return apiUserName.equals(extractTokenUserName(jwsToken)) && !isTokenExpired(jwsToken);
    }
}
