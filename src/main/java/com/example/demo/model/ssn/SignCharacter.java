package com.example.demo.model.ssn;

/**
 * Represents sign characters that are part of the SSN.
 */
public enum SignCharacter {
    PLUS("+"),
    MINUS("-"),
    A("A"),
    INVALID("INVALID");

    private String signValue;

    SignCharacter(String character) {
        this.signValue = character;
    }

    public String getSignValue() {
        return signValue;
    }
}
