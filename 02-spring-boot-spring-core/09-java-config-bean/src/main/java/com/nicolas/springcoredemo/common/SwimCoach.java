package com.nicolas.springcoredemo.common;

public class SwimCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters";
    }
}
