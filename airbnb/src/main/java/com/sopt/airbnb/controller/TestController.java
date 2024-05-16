package com.sopt.airbnb.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "https 테스트";
    }
}
