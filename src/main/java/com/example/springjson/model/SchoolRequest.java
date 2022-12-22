package com.example.springjson.model;


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
}
