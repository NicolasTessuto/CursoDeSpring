package com.nicolas.springcoredemo.controllers;

import com.nicolas.springcoredemo.entities.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define a private field for the dependency
    private Coach coach;

    //Define a constructor for dependency injection
    @Autowired // Not necessary because we have just one constructor
    public DemoController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkou(){
        return coach.getDailyWorkout();
    }



}
