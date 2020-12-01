package com.example.demo_springsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan("com.example.demo_springsecurity.Dao")
public class DemoSpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringsecurityApplication.class, args);
    }



}
