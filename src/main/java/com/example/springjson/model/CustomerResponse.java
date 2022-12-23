package com.example.springjson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private List<CustomerModel> data;
    private Integer successSave;
    private Integer failedSave;
}
