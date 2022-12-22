package com.example.springjson.entity;

import com.example.springjson.model.CustomerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer_tab")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "customer_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "customer_id", initialValue = 0, allocationSize = 0)
    private Long id;
    @Column(name = "customer_name", length = 100)
    private String fullName;
    @Column(name = "gender", length = 20)
    private String gender;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "place_of_birth", length = 100)
    private String placeOfBirth;
    @Column(name = "school", length = 100)
    private String school;

    public CustomerEntity(CustomerRequest request) {
        BeanUtils.copyProperties(request,this);
    }
}