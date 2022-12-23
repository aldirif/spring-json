package com.example.springjson.service;

import com.example.springjson.model.*;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> getAll();
    Optional<CustomerModel> getById(Long id);

    CustomerResponse saveAll(CustomerRequest request);
    Optional<CustomerModel> save(CustomerModel model);

    //Optional<AddressModel> saveAddress(AddressModel addressModel);
    Optional<CustomerModel> update(Long id, CustomerModel model);
    Optional<CustomerModel> delete(Long id);
}


