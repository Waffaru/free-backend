package com.example.demo.model;

import com.example.demo.DTO.SsnDTO;
import com.example.demo.model.ssn.CountryCode;
import com.example.demo.model.ssn.SocialSecurityNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SocialSecurityNumberTest {


    @Test
    public void testConstructorWithProperSSN() {
        SsnDTO.Request.Public request = SsnDTO.Request.Public.builder()
                .ssn("131052-308T")
                .countryCode(CountryCode.FI)
                .build();

        SocialSecurityNumber ssn = new SocialSecurityNumber(request.getSsn());

        assertNotNull(ssn.getSign());
        assertNotNull(ssn.getDate());
        assertNotNull(ssn.getAggregateNumber());
        assertNotNull(ssn.getIndividualNumber());
        assertNotNull(ssn.getControlCharacter());
    }

    @Test
    public void testConstructorWithInvalidSSN() {
        SsnDTO.Request.Public request = SsnDTO.Request.Public.builder()
                .ssn("INVALID")
                .countryCode(CountryCode.FI)
                .build();

        SocialSecurityNumber ssn = new SocialSecurityNumber(request.getSsn());

        assertNull(ssn.getSign());
        assertNull(ssn.getDate());
        assertNull(ssn.getAggregateNumber());
        assertNull(ssn.getIndividualNumber());
        assertNull(ssn.getControlCharacter());
    }

}