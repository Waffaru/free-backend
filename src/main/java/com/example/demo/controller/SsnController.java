package com.example.demo.controller;

import com.example.demo.DTO.SsnDTO;
import com.example.demo.service.SsnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social")
public class SsnController {

    @Autowired
    SsnService ssnService;


    @PostMapping
    public ResponseEntity<Boolean> validateSsn(@RequestBody SsnDTO.Request.Public request) {
            return new ResponseEntity<>(ssnService.validateSsn(request), HttpStatus.OK);
    }

}
