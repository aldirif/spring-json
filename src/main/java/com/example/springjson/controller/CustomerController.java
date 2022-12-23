package com.example.springjson.controller;

import com.example.springjson.model.CustomerRequest;
import com.example.springjson.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService service;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.service = customerService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CustomerRequest request){
        return ResponseEntity.ok().body(
                service.saveAll(request)
        );
    }

}

