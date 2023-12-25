package com.tulingxueyuan.springcloud;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String test123 = bCryptPasswordEncoder.encode("test123");
        System.out.println(test123);
    }
}
