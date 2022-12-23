package com.example.springjson.entity;

import com.example.springjson.model.SchoolModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "schools_tab")
public class SchoolEntity {
    @Id
    @TableGenerator(name = "school_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="school_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "school_id_generator")
    private Long id;

    @Column(name = "title", length = 250, nullable = false)
    private String title;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @Column(name = "level", length = 250, nullable = false)
    private String level;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Long customerId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    public SchoolEntity(SchoolModel model) {
        BeanUtils.copyProperties(model, this);
    }
}