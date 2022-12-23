package com.example.springjson.service;

import com.example.springjson.model.*;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerResponse saveAll(CustomerRequest request);
    Optional<CustomerModel> save(CustomerModel model);
}


