package com.example.demo.DTO;

import com.example.demo.model.ssn.CountryCode;
import lombok.Builder;
import lombok.Value;

/**
 * DTO class for SSN related queries.
 */
public enum SsnDTO {
    ;
    private interface ssn {
        /**
         * The SSN (Social Security Number) received in the request
         * @return string representing SSN
         */
        String getSsn();
    }
    private interface countryCode {

        /**
         * The country code received as part of the request
         * @return received country cocde
         */
        CountryCode getCountryCode();
    }

    public enum Request {
        ;
        @Builder
        @Value
        public static class Public implements ssn, countryCode {
            String ssn;
            CountryCode countryCode;
        }
    }


}