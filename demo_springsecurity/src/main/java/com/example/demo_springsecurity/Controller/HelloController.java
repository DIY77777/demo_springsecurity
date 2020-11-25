package com.example.demo_springsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 关 on 2020/11/21 15:15
 */
@RestController
public class HelloController {

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }
    @GetMapping("/db/hello")
    public String db() {
        return "hello db";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}

