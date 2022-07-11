package com.example.demo.util;


import org.quartz.*;

import java.util.Date;

public class JobUtils {
    private JobUtils() {}


    public static Trigger buildTrigger(final Class jobClass) {

        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(1);
        builder.repeatForever();

        return TriggerBuilder
                .newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(builder)
                .startAt(new Date(System.currentTimeMillis() + 100))
                .build();
    }

    public static JobDetail buildJobDetail(final Class jobClass) {

        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getSimpleName())
                .build();

    }
}
