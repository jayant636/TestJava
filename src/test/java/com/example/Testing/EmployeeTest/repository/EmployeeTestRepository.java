package com.example.Testing.EmployeeTest.repository;

import com.example.Testing.EmployeeTest.TestContainerConfiguration;
import com.example.Testing.EmployeeTest.dto.EmployeeDto;
import com.example.Testing.EmployeeTest.entity.EmployeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Import(TestContainerConfiguration.class)
@DataJpaTest
public class EmployeeTestRepository {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeEntity employee;

    private EmployeeDto employeeDto;



    @BeforeEach
    void setup(){

    }

    @Test
    void testFindByEmail(){
        //Arrange
        employee = EmployeeEntity
                .builder()
                .empId(1L)
                .empName("Jay2")
                .email("jayantjalan4@gmail.com")
                .build();
        employeeRepository.save(employee);

        //Act
        List<EmployeeEntity> employeeEntities = employeeRepository.findByEmail(employee.getEmail());

        //Assert
        assertThat(employeeEntities).isNotEmpty();
        assertThat(employeeEntities).isNotNull();
        assertThat(employeeEntities.get(0).getEmail()).isEqualTo(employee.getEmail());
    }
}

