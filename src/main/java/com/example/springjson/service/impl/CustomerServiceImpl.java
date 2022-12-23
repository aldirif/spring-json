package com.example.springjson.service.impl;
import com.example.springjson.model.*;
import com.example.springjson.repository.AddressRepo;
import com.example.springjson.repository.SchoolRepo;
import com.example.springjson.service.CustomerService;
import com.example.springjson.entity.CustomerEntity;
import com.example.springjson.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo;
    private AddressRepo addressRepo;
    private SchoolRepo schoolRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, AddressRepo addressRepo, SchoolRepo schoolRepo) {
        this.customerRepo = customerRepo;
        this.addressRepo = addressRepo;
        this.schoolRepo = schoolRepo;
    }


    @Override
    public List<CustomerModel> getAll() {
        return null;
    }

    @Override
    public Optional<CustomerModel> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public CustomerResponse saveAll(CustomerRequest request) {
        if(request.getCustomers().isEmpty()) {
            return new CustomerResponse();
        }
        CustomerResponse response = new CustomerResponse();
        int countSuccess = 0;
        int countFailed = 0;
        List<CustomerModel> customerModels = new ArrayList<>();
        for (CustomerModel model: request.getCustomers()){
            // panggil method save
            Optional<CustomerModel> customerModel = this.save(model);
            // check datanya
            if(customerModel.isPresent()){
                customerModels.add(model);
                countSuccess++;
            }else {
                countFailed++;
            }
        }
        return new CustomerResponse(customerModels, countSuccess, countFailed);

    }

    @Override
    public Optional<CustomerModel> save(CustomerModel model) {

        if (model == null || model.getAddress().isEmpty() || model.getSchools().isEmpty()) {
            return Optional.empty();
        }

        CustomerEntity customerEntity = new CustomerEntity(model);
        customerEntity.addAddressList(model.getAddress());
        customerEntity.addSchoolList(model.getSchools());

        try {
            this.customerRepo.save(customerEntity);
            return Optional.of(new CustomerModel(customerEntity));
        } catch (Exception e) {
            log.error("Customer save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }





    @Override
    public Optional<CustomerModel> update(Long id, CustomerModel model) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerModel> delete(Long id) {
        return Optional.empty();
    }
}
