package com.example.Micro_Resource.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


public class JWTUtil {

    // singleton starts from  here
    public static class JwtUtilBuilder{
        public static final JWTUtil JWT_UTIL = new JWTUtil();
    }
    private JWTUtil(){
        // nothing
    }
    public static JWTUtil getInstance(){
        return JwtUtilBuilder.JWT_UTIL;
    }
    // ends here
    {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        }
        catch (NoSuchAlgorithmException e){
            // log later
            System.out.println("cant authenticate RN");
        }
    }
    private PrivateKey privateKey;
    private PublicKey publicKey;



    public String generateToken(String username,String Role){
// try if failed then raise excepion
      return  Jwts.builder().claim("ROLE_","BASIC")
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plus(5, ChronoUnit.MINUTES)))
                .subject(username).compact();
    }

    public Claims validateAndExtractUsername(String token){
        // try if failed then raise excepion
        return  Jwts.parser()
                .verifyWith(publicKey)
                .build()
                .parseSignedClaims(token)
                .getBody();
    }

}
