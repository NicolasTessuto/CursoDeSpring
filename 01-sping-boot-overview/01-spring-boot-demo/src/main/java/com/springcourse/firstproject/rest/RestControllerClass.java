package com.springcourse.firstproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerClass {
    @GetMapping("/")
    public String hello(){
        return "Hello World!";
    }





}
