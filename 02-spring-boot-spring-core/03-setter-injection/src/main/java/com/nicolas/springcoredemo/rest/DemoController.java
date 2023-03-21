package com.nicolas.springcoredemo.rest;

import com.nicolas.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define a private field for the dependency
    private Coach coach;


    //Because of autowired annotation the name is independent
    @Autowired
    public void setCoach(Coach coach) {
        this.coach = coach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkou(){
        return coach.getDailyWorkout();
    }




}
