package com.nicolas.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 30 min in batting practice";
    }
}
