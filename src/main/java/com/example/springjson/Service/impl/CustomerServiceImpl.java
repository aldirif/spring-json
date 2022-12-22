package com.example.springjson.Service.impl;

import com.example.springjson.Service.CustomerService;
import com.example.springjson.entity.CustomerEntity;
import com.example.springjson.model.CustomerModel;
import com.example.springjson.repository.AddressRepo;
import com.example.springjson.repository.CustomerRepo;
import com.example.springjson.repository.SchoolRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
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
    public Optional<CustomerModel> save(CustomerModel model) {
        if(model == null || model.getAddress().isEmpty() || model.getSchools().isEmpty()) {
            return Optional.empty();
        }

        CustomerEntity entity = new CustomerEntity(model);
        entity.addAddressList(model.getAddress());
        entity.addSchoolList(model.getSchools());

        try{
            customerRepo.save(entity);
            return Optional.of(model);
        }catch (Exception e){
            log.error("Customer save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
