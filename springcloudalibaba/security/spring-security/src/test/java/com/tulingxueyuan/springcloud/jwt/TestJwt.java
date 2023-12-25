package com.tulingxueyuan.springcloud.jwt;

import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestJwt {
    private static final String KEY="ludasdaasdasdasdasdasdcylvludasdaasdasdasdasdasdcylvludasdaasdasdasdasdasdcylv";
    //创建jons web token == jwt
    @Test
    public void testCreateToken(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("userId","132");

        //创建jwt对象
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置负载的内容
                .setClaims(map)
                .setIssuedAt(new Date())//jwt的签发时间
                .signWith(SignatureAlgorithm.HS256, KEY);//设置签名算法和盐
        String token = jwtBuilder.compact();
        System.out.println(token);
    }
    @Test
    public void testParseToken(){
        String token="eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIxMzIiLCJpYXQiOjE3MDM0NjcyOTR9.fW--qQ7J4MjT0Z7_06BpmeKHDWgAsUzmPgM0NGnDn4A";
        JwtParser jwtParser = Jwts.parser().setSigningKey(KEY).build();
        Claims cliams = jwtParser.parseClaimsJws(token).getBody();
        String userId = cliams.get("userId", String.class);
        System.out.println(userId);
    }

    @Test
    public void testExpToken() throws InterruptedException {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("userId","132");
        //创建jwt对象
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置负载的内容
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis()+3*1000))
                .setIssuedAt(new Date())//jwt的签发时间
                .signWith(SignatureAlgorithm.HS256, KEY);//设置签名算法和盐
        String token = jwtBuilder.compact();
        System.out.println(token);
        TimeUnit.SECONDS.sleep(4);
        JwtParser jwtParser = Jwts.parser().setSigningKey(KEY).build();
        Claims cliams = jwtParser.parseClaimsJws(token).getBody();
        String userId = cliams.get("userId", String.class);
        System.out.println(userId);

    }
}
