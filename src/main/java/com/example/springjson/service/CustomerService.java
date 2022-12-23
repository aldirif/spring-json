package com.example.springjson.service;

import com.example.springjson.model.CustomerModel;
import com.example.springjson.model.CustomerRequest;
import com.example.springjson.model.CustomerResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> getAll();
    Optional<CustomerModel> getById(Long id);
    CustomerResponse saveAll(CustomerRequest request);
    Optional<CustomerModel> save(CustomerModel model);
    Optional<CustomerModel> update(Long id, CustomerModel model);
    Optional<CustomerModel> delete(Long id);
}


