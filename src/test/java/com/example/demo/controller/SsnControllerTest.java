package com.example.demo.controller;

import com.example.demo.FreeApplication;
import com.example.demo.service.SsnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SsnController.class)
class SsnControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SsnService ssnService;


    @Test
    void validateSsn_shouldReturnOk() throws Exception {

        mockMvc.perform(
                post("/social")
                    .contentType("application/json")
                    .content("{\"ssn\": \"131052-308T\",\"countryCode\": \"FI\"}"
                    )
                )
                .andExpect(status().isOk());

    }

    @Test
    void validateSsn_shouldFail() throws Exception {

        mockMvc.perform(
                        post("/social")
                                .contentType("application/json")
                                .content("not json"
                                )
                )
                .andExpect(status().isBadRequest());
    }
}