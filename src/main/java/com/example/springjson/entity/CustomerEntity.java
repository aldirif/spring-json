package com.example.springjson.entity;

import com.example.springjson.model.AddressModel;
import com.example.springjson.model.CustomerModel;
import com.example.springjson.model.SchoolModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer_req_tab")
public class CustomerEntity {
    @Id
    @TableGenerator (name = "customer_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="customer_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_id_generator")
    private Long id;

    @Column(name = "fullName", length = 100, nullable = false)
    private String fullName;

    @Column(name = "gender", length = 15, nullable = false)
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addressEntities = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SchoolEntity> schoolEntities = new ArrayList<>();

    public CustomerEntity(CustomerModel model){
        BeanUtils.copyProperties(model, this);
    }

    public void addAddress(AddressEntity address){
        this.addressEntities.add(address);
        address.setCustomer(this);
    }

    public void addAddressList(List<AddressModel> addressModels){
        for(AddressModel item: addressModels){
            AddressEntity addressEntity = new AddressEntity(item);
            addAddress(addressEntity);
        }
    }

    public void addSchool(SchoolEntity school){
        this.schoolEntities.add(school);
        school.setCustomer(this);
    }

    public void addSchoolList(List<SchoolModel> schoolModels){
        for(SchoolModel item2: schoolModels){
            SchoolEntity schoolEntity = new SchoolEntity(item2);
            addSchool(schoolEntity);
        }
    }
}