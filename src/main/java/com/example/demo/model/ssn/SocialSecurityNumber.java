package com.example.demo.model.ssn;

import lombok.*;

import java.util.Arrays;

/**
 * Model class representing a social security number.
 */
@Getter
public class SocialSecurityNumber {

    private String date;
    private SignCharacter sign;
    private String individualNumber;
    private ControlCharacter controlCharacter;
    private Integer aggregateNumber; // convenience private property, precalculated aggregate number used in verification of control character.

    public SocialSecurityNumber(String ssn) {
        if(ssn.length() == 11) {
            this.date = ssn.substring(0, 6);
            this.sign = Arrays.stream(SignCharacter.values()).toList().stream().filter(signCharacter -> signCharacter.getSignValue().equals(ssn.substring(6, 7))).findAny().orElse(SignCharacter.INVALID);
            this.individualNumber = ssn.substring(7, 10);
            this.controlCharacter = Arrays.stream(ControlCharacter.values()).filter(controlCharacter1 -> controlCharacter1.getStringValue().equals(ssn.substring(ssn.length() -1))).findAny().orElse(ControlCharacter.INVALID);
            this.aggregateNumber = Integer.parseInt(ssn.replaceAll("[^0-9.]", ""));
        }
    }
}
