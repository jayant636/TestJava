package com.example.Testing.EmployeeTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping(path = "/")
    public String healthCheckController(){
        return "Ok";
    }
}
