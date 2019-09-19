package com.mf.mofang.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.SignatureException;

/**
 * @author pt
 */
public class JwtUtil {
    //需要key.map,颜值三个组成部分
    private static final String key = "AHFOAUSCNWHEHQOHNDFJDASDG";

    //3、   签名部分
    //根据用户信息+盐值+密钥生成的签名。
    public static String encode(String username) {

        //生成签名部分
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key);
        jwtBuilder = jwtBuilder.setSubject(username);
        //获取生成的token
        String token = jwtBuilder.compact();
        return token;
    }

    public static String decode(String token) throws SignatureException {
//        Claims claims = null;

        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
//        return claims;
    }

    public static Claims getClaimByToken(String token) {
//        Claims claims = null;

        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
//        return claims;
    }
}