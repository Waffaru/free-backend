package com.example.demo.schedule;

import com.example.demo.util.JobUtils;
import lombok.extern.log4j.Log4j2;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Log4j2
public class SchedulerService {

    @Autowired
    private Scheduler scheduler;

    public void schedule(final Class jobClass) {

        System.out.println(jobClass.getSimpleName());
        final JobDetail jobDetail = JobUtils.buildJobDetail(jobClass);
        final Trigger trigger = JobUtils.buildTrigger(jobClass);

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }

    }

    @PostConstruct
    public void init() {
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }

    @PreDestroy
    public void preDestroy() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
        }
    }


}
