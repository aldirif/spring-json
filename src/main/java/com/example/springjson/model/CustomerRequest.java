package com.example.springjson.model;

import com.example.springjson.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private Long id;
    private String fullName;
    private String gender;
    private Date dateOfBirth;
    private String placeOfBirth;
    private List<AddressRequest> address = new ArrayList<>();
    private List<SchoolRequest> schools = new ArrayList<>();

    public CustomerRequest(CustomerEntity entity) {
        BeanUtils.copyProperties(entity,this);
    }
}
