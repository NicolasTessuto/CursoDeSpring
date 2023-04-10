package com.nicolas.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    public BaseBallCoach(){
        System.out.println("In the constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 min in batting practice";
    }
}
