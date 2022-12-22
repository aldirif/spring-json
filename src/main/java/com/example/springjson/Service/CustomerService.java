package com.example.springjson.Service;

import com.example.springjson.model.CustomerModel;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerModel> save(CustomerModel model);
}
