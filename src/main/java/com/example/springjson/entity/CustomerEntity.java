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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_tab")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "cus_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="customer_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cus_id_generator")
    private Long id;

    @Column(name = "full_name", length = 100)
    private String fullName;
    @Column(name = "gander", length = 10)
    private String gender;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "place_of_birth", length = 100)
    private String placeOfBirth;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<AddressEntity> address = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<SchoolEntity> schools = new HashSet<>();

    public CustomerEntity(CustomerModel model) {
        BeanUtils.copyProperties(model,this);
    }
}

