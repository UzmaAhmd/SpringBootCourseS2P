package com.example14.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/api/v1/hello")
    // access this using http://localhost:8080/api/v1/hello on chrome
    public String sayHello(){
        return "Hello frm Spring  web server";
    }

    @GetMapping("/api/v1/uzma")
    public String getMyNam() {
        return"UZMA AHMAD";
    }
}
