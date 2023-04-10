package com.nicolas.springcoredemo.config;

import com.nicolas.springcoredemo.common.Coach;
import com.nicolas.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }


}
