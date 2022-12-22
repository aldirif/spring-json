package com.example.springjson.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolModel {
    private Long id;
    private String title;
    private String name;
    private String level;
}
