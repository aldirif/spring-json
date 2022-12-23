package com.example.springjson.model;

import com.example.springjson.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String village;
    private String district;
    private String city;
    private String province;

    public AddressModel(AddressEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}


