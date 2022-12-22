package com.example.springjson.model;

import com.example.springjson.entity.CustomerEntity;
import com.example.springjson.entity.SchoolEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolRequest {
    private String title;
    private String name;
    private String level;

    public SchoolRequest(SchoolEntity entity) {
        BeanUtils.copyProperties(entity,this);
    }
}
