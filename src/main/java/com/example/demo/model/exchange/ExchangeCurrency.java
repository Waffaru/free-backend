package com.example.demo.model.exchange;

/**
 * Enum representing available currencies to do exchange operations with within the application.
 */
public enum ExchangeCurrency {
    EUR,
    SEK,
    USD;

    public static String[] names() {
        ExchangeCurrency[] states = values();
        String[] names = new String[states.length];

        for (int i = 0; i < states.length; i++) {
            names[i] = states[i].name();
        }

        return names;
    }
}
