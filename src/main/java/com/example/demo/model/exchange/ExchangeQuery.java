package com.example.demo.model.exchange;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeQuery {
    int amount;
    String from;
    String to;
}
