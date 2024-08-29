package com.example.Testing.EmployeeTest.service;

import com.example.Testing.EmployeeTest.TestContainerConfiguration;
import com.example.Testing.EmployeeTest.dto.EmployeeDto;
import com.example.Testing.EmployeeTest.entity.EmployeeEntity;
import com.example.Testing.EmployeeTest.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.shaded.org.checkerframework.checker.index.qual.Positive;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@DataJpaTest //To run this specific test file only
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestContainerConfiguration.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Spy
    private ModelMapper modelMapper ;

    @InjectMocks
    private EmployeeService employeeService;
    private EmployeeDto mockemployeeDto;
    private EmployeeEntity mockemployee;

    @BeforeEach
    void setup(){
        mockemployee = EmployeeEntity
                .builder()
                .empId(1L)
                .email("jayantjalan4@gmail.com")
                .empName("Jay2")
                .build();
         mockemployeeDto = modelMapper.map(mockemployee,EmployeeDto.class);
    }

//    positive case -> When everything is going fine
//    Negative case -> When everything is not going right


    @Test
    void getEmployeeByIdTestsPositiveCase(){
        //  Postive
        //Assign
        Long id = mockemployee.getEmpId();
        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockemployee));

        //Act
        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(id);

        //Assert
        assertThat(employeeDto.get().getEmpId()).isEqualTo(id);
        assertThat(employeeDto.get().getEmail()).isEqualTo(mockemployee.getEmail());
    }

//    @Test
//    void getEmployeeByIdTestsNegativeCase(){
////        Negative
////        Arrange
//        when(employeeRepository.findById(any())).thenReturn(Optional.empty());
//
////        Act + Assert
//        assertThatThrownBy(()-> employeeService.getEmployeeById(1L))
//                .isInstanceOf(RuntimeException.class)
//                .hasMessage("Employee not found ");
//        verify(employeeRepository).findById(1l);
//
//
//    }



    @Test
    void createNewEmployeeTest_whenitdoesnotexist(){
//        Positive
        //Assign
//          when(employeeRepository.findByEmail(anyString())).thenReturn(List.of());
          when(employeeRepository.save(any(EmployeeEntity.class))).thenReturn(mockemployee);

        //Act
           EmployeeDto employeeDto = employeeService.createNewEmployee(mockemployeeDto);
        //Assert
//        assertThat(employeeDto).isNotNull();
//        assertThat(employeeDto.getEmail()).isEqualTo(mockemployeeDto.getEmail());

        verify(employeeRepository).save(any(EmployeeEntity.class));
    }


//    @Test
//    void createNewEmployeeTestWhen_itisalreadyexists(){
//
////        Negative
//        when(employeeRepository.findByEmail(mockemployeeDto.getEmail())).thenReturn(List.of());
//
//        assertThatThrownBy(()-> employeeService.createNewEmployee(mockemployeeDto))
//                .isInstanceOf(RuntimeException.class)
//                .hasMessage("User already exists");
//
//        verify(employeeRepository).findByEmail(mockemployeeDto.getEmail());
//        verify(employeeRepository).save(any());
//    }

}
