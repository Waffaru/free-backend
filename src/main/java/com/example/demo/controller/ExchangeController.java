package com.example.demo.controller;

import com.example.demo.DTO.ExchangeDTO;
import com.example.demo.model.exchange.ExchangeCurrency;
import com.example.demo.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @GetMapping
    ResponseEntity<ExchangeDTO.Response.Public> getExchange(
            @RequestParam("from")ExchangeCurrency from,
            @RequestParam("to") ExchangeCurrency to,
            @RequestParam("from_amount") Integer fromAmount
            ) {
        return new ResponseEntity<>(exchangeService.exchangeAmount(from, to, fromAmount), HttpStatus.OK);
    }

}
