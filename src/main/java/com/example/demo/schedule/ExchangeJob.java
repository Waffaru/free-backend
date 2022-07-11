package com.example.demo.schedule;


import com.example.demo.service.ExchangeService;
import lombok.extern.log4j.Log4j2;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ExchangeJob implements Job {

    @Autowired
    ExchangeService exchangeService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("Updating exchange rates");
        exchangeService.updateExchangeRates();
    }

}
