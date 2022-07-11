package com.example.demo.DTO;

import com.example.demo.model.exchange.ExchangeCurrency;
import lombok.Builder;
import lombok.Value;

/**
 * DTO class for Exchange related queries
 */
public enum ExchangeDTO {
    ;
    private interface from {
        /**
         * The original currency we're exchanging from.
         * @return the original currency.
         */
        ExchangeCurrency getFrom();
    }
    private interface to {
        /**
         * The target currency we're exchanging the currency to
         * @return the target currency.
         */
        ExchangeCurrency getTo();
    }
    private interface toAmount {
        /**
         * The resulting amount of target currency we receive from the exchange
         * @return exchange amount
         */
        String getToAmount();
    }
    private interface exchangeRate {

        /**
         * The exchange rate used in the conversion of currencies
         * @return exchange rate
         */
        Double getExchangeRate();
    }

    public enum Response {;

        @Builder
        @Value
        public static class Public implements from, to, toAmount, exchangeRate {
            ExchangeCurrency from;
            ExchangeCurrency to;
            String toAmount;
            Double exchangeRate;
        }

    }

}
