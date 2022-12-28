package com.example.springjson.service.impl;

import com.example.springjson.entity.AddressEntity;
import com.example.springjson.entity.CustomerEntity;
import com.example.springjson.entity.SchoolEntity;
import com.example.springjson.model.AddressModel;
import com.example.springjson.model.CustomerModel;
import com.example.springjson.model.SchoolModel;
import com.example.springjson.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @InjectMocks
    @Autowired
    private CustomerServiceImpl service;

    @Mock
    private CustomerRepo repo;

    private List<CustomerEntity> customerEntityList;

    @BeforeEach
    void setUp() {
        log.info("Setup Run ...");
        customerEntityList = Arrays.asList(
                new CustomerEntity(1L, "Kezia", "Wanita Sholehah"),
                new CustomerEntity(2L, "Yoga", "Pria Perkasa"),
                new CustomerEntity(3L, "Umi", "Wanita Tangguh")
        );
    }

    @AfterEach
    void tearDown() {
        log.info("Setup Clear ..");
    }

    @Test
    void getAll() {
        //Mocking => perumpamaan // pura pura // boong
        // ketika ada request repo.findAll , maka kembalikan value List kosong
        when(this.repo.findAll()).thenReturn(Collections.emptyList());
        List<CustomerModel> result = service.getAll();
        assertNotNull(result);
        assertEquals(0, result.size());

        when(this.repo.findAll()).thenReturn(customerEntityList);
        result = service.getAll();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Kezia", result.get(0).getFullName());
        assertEquals("Wanita Sholehah", result.get(0).getGender());

    }

    @Test
    void getById() {
        Optional<CustomerModel> result = service.getById(0L);
        assertEquals(Optional.empty(), result);

        CustomerEntity customerEntity = new CustomerEntity(1L, "Kezia", "Wanita Sholehah");
        Optional<CustomerEntity> optional = Optional.of(customerEntity);

        // mocking
        when(repo.findById(1L)).thenReturn(optional);
        result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        assertEquals("Kezia", result.get().getFullName());
        assertEquals("Wanita Sholehah", result.get().getGender());

    }

    @Test
    void saveAll() {
    }

    @Test
    void save() {
        Optional<CustomerModel> result = this.service.save(null);
        assertEquals(Optional.empty(), result);
        List<AddressModel> addressModels = Arrays.asList(
                new AddressModel("budi","Address 1", "Jl. Jalan 1, Sukahurip", "Pamarican","Ciamis","Jawa Barat"),
                new AddressModel("andi","Address 2", "Jl. Jalan 2, Sukahurip", "Pamarican","Ciamis","Jawa Barat")
        );

        List<SchoolModel> schoolModels = Arrays.asList(
                new SchoolModel("SD","SDN 1 Test", "SD"),
                new SchoolModel("SMP","SMP 1 Test", "SMP"),
                new SchoolModel("SMA","SMA 1 Test", "SMA")
        );

        // prepare data request
        CustomerModel model = new CustomerModel(1L,"Joko", addressModels,"Pria", new Date(),
                "Jakarta", schoolModels
        );

        // prepare response dari repo save
        CustomerEntity entity = new CustomerEntity(model);
        List<AddressEntity> addressEntities = addressModels.stream().map(AddressEntity::new).collect(Collectors.toList());
        entity.setAddressEntities(addressEntities);

        List<SchoolEntity> schoolEntities = schoolModels.stream().map(SchoolEntity::new).collect(Collectors.toList());
        entity.setSchoolEntities(schoolEntities);

        when(this.repo.save(any(CustomerEntity.class))).thenReturn(entity);
        result = this.service.save(model);
        assertNotNull(result);
        assertEquals("Joko", result.get().getFullName());
        assertEquals("Pria", result.get().getGender());
        assertEquals("Jakarta", result.get().getPlaceOfBirth());

        // validasi address
        assertEquals(2, result.get().getAddress().size());
        assertEquals(3, result.get().getSchools().size());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}