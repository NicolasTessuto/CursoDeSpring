package com.nicolas.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseBallCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 30 min in batting practice";
    }
}
