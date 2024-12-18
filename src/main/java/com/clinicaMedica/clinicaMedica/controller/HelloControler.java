package com.clinicaMedica.clinicaMedica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ola")
public class HelloControler {

    @GetMapping
    public String hello(){
        return "ola mundo!!!";
    }
}
