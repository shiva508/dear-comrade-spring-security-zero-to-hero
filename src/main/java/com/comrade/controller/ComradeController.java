package com.comrade.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ComradeController {

    @GetMapping("/welcome")
    public Map<String, String> helloSecurity(){
        return Map.of("name","Shiva");
    }
}
