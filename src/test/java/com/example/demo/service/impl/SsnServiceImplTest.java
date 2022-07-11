package com.example.demo.service.impl;

import com.example.demo.DTO.SsnDTO;
import com.example.demo.service.SsnService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {SsnServiceImpl.class})
class SsnServiceImplTest {

    @Autowired
    SsnService ssnService;

    @Mock
    SsnDTO.Request.Public ssnRequest;

    @Test
    void validateSsn_valid() {

        Mockito.when(ssnRequest.getSsn()).thenReturn("131052-308T");

        assertTrue(ssnService.validateSsn(ssnRequest));
    }

    @Test
    void validateSsn_invalid() {

        Mockito.when(ssnRequest.getSsn()).thenReturn("131052-308K");

        assertFalse(ssnService.validateSsn(ssnRequest));
    }
}