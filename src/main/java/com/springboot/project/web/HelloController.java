package com.springboot.project.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ①
public class HelloController {
    @GetMapping("/hello") // ②
    public String hello(){
        return "hello";
    }
}