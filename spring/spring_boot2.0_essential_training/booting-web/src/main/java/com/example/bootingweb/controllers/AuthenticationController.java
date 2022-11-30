package com.example.bootingweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")   // http://localhost:8080/login
    public String getLogin(){
        return "login";
    }
}
