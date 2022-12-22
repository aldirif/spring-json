package com.example.springjson.controller;

import com.example.springjson.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    @PostMapping()
    public ResponseEntity<Object> saveCustomer(@RequestBody ResponseModel model){
        return ResponseEntity.ok().body(model);
    }
}
