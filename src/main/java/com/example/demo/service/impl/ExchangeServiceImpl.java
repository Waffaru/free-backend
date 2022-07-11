package com.example.demo.service.impl;

import com.example.demo.DTO.ExchangeDTO;
import com.example.demo.model.exchange.ExchangeCurrency;
import com.example.demo.model.exchange.ExchangeRates;
import com.example.demo.model.exchange.ExchangeResponse;
import com.example.demo.service.ExchangeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.Optional;

@Service
@Log4j2
public class ExchangeServiceImpl implements ExchangeService {

    ExchangeRates exchangeRates;

    @Value("${exchange.apikey}")
    private String apiKey;

    @Override
    public ExchangeDTO.Response.Public exchangeAmount(ExchangeCurrency from, ExchangeCurrency to, Integer fromAmount) {

        ExchangeResponse response = convertCurrency(from,to, fromAmount).orElseThrow();

        return ExchangeDTO.Response.Public.builder()
                .from(from)
                .to(to)
                .toAmount(response.getResult())
                .exchangeRate(response.getInfo().getRate())
                .build();
    }

    @Override
    public void updateExchangeRates() {

        HttpClient client  = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .headers("apikey", apiKey)
                .uri(URI.create(MessageFormat.format("https://api.apilayer.com/exchangerates_data/latest?symbols={0}", String.join(",", ExchangeCurrency.names()))))
                .build();

        ObjectMapper mapper = new ObjectMapper();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            exchangeRates = mapper.readValue(response.body(), ExchangeRates.class);
            log.info("New Exchanger rates: {}", exchangeRates.getRates());
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage(), e);
        }

    }


    private Optional<ExchangeResponse> convertCurrency(ExchangeCurrency from, ExchangeCurrency to, Integer amount) {

        HttpClient client  = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .headers("apikey", apiKey)
                .uri(URI.create(MessageFormat.format("https://api.apilayer.com/exchangerates_data/convert?to={0}&from={1}&amount={2}", to, from, amount)))
                .build();

        ObjectMapper mapper = new ObjectMapper();

        HttpResponse<String> response;
        ExchangeResponse exchangeResponse;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            exchangeResponse = mapper.readValue(response.body(), ExchangeResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return Optional.empty();
        }

        return Optional.of(exchangeResponse);
    }
}
