package com.example.demo.model.exchange;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Model class representing a response from the exchange API that the application uses.
 */
@Getter
@Setter
public class ExchangeResponse {

    Date date;
    String historical;
    ExchangeInfo info;
    ExchangeQuery query;
    String result;
    Boolean success;

}
