package com.example.demo.service;

import com.example.demo.DTO.SsnDTO;

/**
 * Service layer containing SSN validation related operation
 */
public interface SsnService {

    /**
     * Checks whether given SSN is valid.
     * @param request The request SSN to be verified.
     * @return boolean value, true for valid and false for invalid.
     */
    Boolean validateSsn(SsnDTO.Request.Public request);

}
