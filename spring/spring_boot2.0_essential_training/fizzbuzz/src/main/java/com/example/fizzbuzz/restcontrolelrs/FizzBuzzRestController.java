package com.example.fizzbuzz.restcontrolelrs;

import com.example.fizzbuzz.services.FizzBuzzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FizzBuzzRestController {
    private final FizzBuzzService fizzBuzzService;

    public FizzBuzzRestController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @GetMapping("/fizzbuzz")
    public List getFizzBuzz(){
        return fizzBuzzService.getFizzBuzz();
    }
}
