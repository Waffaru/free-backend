package com.example.demo.model.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRateData {

    @JsonProperty("EUR")
    Double eur;
    @JsonProperty("SEK")
    Double sek;
    @JsonProperty("USD")
    Double usd;

    @Override
    public String toString() {
        return "ExchangeRateData{" +
                "eur=" + eur +
                ", sek=" + sek +
                ", usd=" + usd +
                '}';
    }
}
