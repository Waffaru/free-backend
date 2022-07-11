package com.example.demo.model.ssn;

/**
 * Enum class representing all available control characters for a SSN.
 * Each enum contains its integer position and also its actual character representation for ease of conversion.
 */
public enum ControlCharacter {
    ONE(1, "1"),
    TWO( 2,"2"),
    THREE( 3,"3"),
    FOUR(4,"4"),
    FIVE(5,"5"),
    SIX(6, "6"),
    SEVEN(7,"7"),
    EIGHT(8, "8"),
    NINE(9,"9"),
    TEN(10,"A"),
    ELEVEN(11,"B"),
    TWELVE(12,"C"),
    THIRTEEN(13,"D"),
    FOURTEEN(14,"E"),
    FIFTEEN(15,"F"),
    SIXTEEN(16,"H"),
    SEVENTEEN(17,"J"),
    EIGHTEEN(18,"K"),
    NINETEEN(19,"L"),
    TWENTY(20,"M"),
    TWENTYONE(21,"N"),
    TWENTYTWO(22,"P"),
    TWENTYTHREE(23,"R"),
    TWENTYFOUR(24,"S"),
    TWENTYFIVE(25,"T"),
    TWENTYSIX(26,"U"),
    TWENTYSEVEN(27,"V"),
    TWENTYEIGHT(28,"W"),
    TWENTYNINE(29,"X"),
    THIRTY(30,"Y"),
    INVALID(99, "INVALID");

    private String stringValue;
    private int intValue;
    ControlCharacter(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

}
