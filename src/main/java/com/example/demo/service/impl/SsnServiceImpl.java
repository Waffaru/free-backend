package com.example.demo.service.impl;

import com.example.demo.DTO.SsnDTO;
import com.example.demo.model.ssn.ControlCharacter;
import com.example.demo.model.ssn.SignCharacter;
import com.example.demo.model.ssn.SocialSecurityNumber;
import com.example.demo.service.SsnService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@Log4j2
public class SsnServiceImpl implements SsnService {
    @Override
    public Boolean validateSsn(SsnDTO.Request.Public request) {
        if(request.getSsn().length() != 11) {
            return false;
        }
        SocialSecurityNumber ssn = new SocialSecurityNumber(request.getSsn());
        return validateSignCharacter(ssn) && validateControlCharacter(ssn) && validatePersonalIdentityCode(ssn);
    }

    private Boolean validateSignCharacter(SocialSecurityNumber ssn) {
        return ssn.getSign() != SignCharacter.INVALID;
    }

    private Boolean validateControlCharacter(SocialSecurityNumber ssn) {
        return ssn.getControlCharacter() != ControlCharacter.INVALID;
    }

    private Boolean validatePersonalIdentityCode(SocialSecurityNumber ssn) {
        double number = (double) ssn.getAggregateNumber() / 31;
        int decimal = (int) number;
        double control =  Math.round((number - decimal) * 31);
        ControlCharacter controlCharacter = Arrays.stream(ControlCharacter.values()).toList().stream().filter(cc -> cc.getIntValue() == control).collect(Collectors.toList()).get(0);
        return controlCharacter == ssn.getControlCharacter();
    }
}
