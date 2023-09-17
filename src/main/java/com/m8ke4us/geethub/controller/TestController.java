package com.m8ke4us.geethub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/api")
public class TestController {
    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }
}
