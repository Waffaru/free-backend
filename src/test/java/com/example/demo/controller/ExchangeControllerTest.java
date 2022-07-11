package com.example.demo.controller;

import com.example.demo.service.ExchangeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ExchangeController.class)
class ExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ExchangeService exchangeService;

    @Test
    void getExchange_shouldReturnOk() throws Exception {

        mockMvc.perform(
                        get("/exchange?from=USD&to=EUR&from_amount=100")
                )
                .andExpect(status().isOk());

    }
    @Test
    void getExchange_shouldFail() throws Exception {

        mockMvc.perform(
                        get("/exchange?from=USD&to=EUR&from_amount=invalidinput")
                )
                .andExpect(status().isBadRequest());

    }
}