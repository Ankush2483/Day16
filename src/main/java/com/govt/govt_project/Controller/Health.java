package com.govt.govt_project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {
    @GetMapping("/health_check")
    public String healthCheck(){
        return "ok";
    }
}
