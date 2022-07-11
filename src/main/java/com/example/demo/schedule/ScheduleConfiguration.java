package com.example.demo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@Profile("!test")
@EnableScheduling
public class ScheduleConfiguration {


    @Autowired
    SchedulerService schedulerService;


    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> schedulerService.schedule(ExchangeJob.class);
    }

}
