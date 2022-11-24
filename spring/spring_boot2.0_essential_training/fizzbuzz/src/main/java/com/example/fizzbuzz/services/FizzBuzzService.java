package com.example.fizzbuzz.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzService {
    private final List<Integer> numList;

    public FizzBuzzService() {
        this.numList = IntStream.rangeClosed(1,100).boxed().collect(Collectors.toList());
    }

    public List getFizzBuzz(){
        return this.numList
                .stream()
                .map(num -> (num%3==0&&num%5==0)?"FizzBuzz":
                        (num%3==0)?"Fizz":
                                (num%5==0)?"Buzz":num)
                .collect(Collectors.toList());
    }
}
