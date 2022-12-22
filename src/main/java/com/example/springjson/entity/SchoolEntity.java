package com.example.springjson.entity;

import com.example.springjson.model.AddressModel;
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
    @TableGenerator(name = "schools_id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "schools_id", initialValue = 0, allocationSize = 0)

    @GeneratedValue(strategy = GenerationType.TABLE, generator = "schools_id_generator")
    private Long id;

    @Column(name = "title", length = 10, nullable = false)
    private String title;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "level", length = 25, nullable = false)
    private String level;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    public SchoolEntity(SchoolModel model) {
        this.title = model.getTitle();
        this.name = model.getName();
        this.level = model.getLevel();
    }
}
