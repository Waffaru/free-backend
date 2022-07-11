package com.example.demo.service;

import com.example.demo.DTO.ExchangeDTO;
import com.example.demo.model.exchange.ExchangeCurrency;

/**
 * Service layer containing currency exchange related operations
 */
public interface ExchangeService {

    /**
     * Runs an exchange operation with given parameters and returns the result as a DTO.
     * @param from The original currency to exchange from
     * @param to The currency we're exchanging to
     * @param fromAmount the original currency amount being exchanged
     * @return a DTO containing information related to the exchange.
     */
    ExchangeDTO.Response.Public exchangeAmount(ExchangeCurrency from, ExchangeCurrency to, Integer fromAmount);

    /**
     * Fetches exchange rates from API and updates them accordingly.
     */
    void updateExchangeRates();

}
