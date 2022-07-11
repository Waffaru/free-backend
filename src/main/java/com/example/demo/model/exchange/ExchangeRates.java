package com.example.demo.model.exchange;

import lombok.Getter;
import lombok.Setter;

/**
 * Model class representing Exchange rates available and related data
 */
@Getter
@Setter
public class ExchangeRates {

    String base;
    String date;
    ExchangeRateData rates;
    Boolean success;
    Integer timestamp;

}
