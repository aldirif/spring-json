package com.example.springjson.entity;

import com.example.springjson.model.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address_tab")
public class AddressEntity {
    @Id
    @TableGenerator(name = "location_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "location_id", initialValue = 0, allocationSize = 0)
    private Long id;
    @Column(name = "location_name", length = 50)
    private String name;
    @Column(name = "address", length = 100)
    private String address;
    @Column(name = "village", length = 100)
    private String village;
    @Column(name = "district", length = 100)
    private String district;
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "province", length = 100)
    private String province;

    public AddressEntity(AddressRequest request) {
        BeanUtils.copyProperties(request,this);
    }
}
