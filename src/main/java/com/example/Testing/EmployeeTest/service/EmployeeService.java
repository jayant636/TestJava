package com.example.Testing.EmployeeTest.service;

import com.example.Testing.EmployeeTest.dto.EmployeeDto;
import com.example.Testing.EmployeeTest.entity.EmployeeEntity;
import com.example.Testing.EmployeeTest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

   private final EmployeeRepository employeeRepository;
   private final ModelMapper modelMapper;


    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        EmployeeEntity newUser = employeeRepository.save(employeeEntity);
        return modelMapper.map(newUser,EmployeeDto.class);
    }


    public List<EmployeeDto> getEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDto.class)).collect(Collectors.toList());

    }

    public Optional<EmployeeDto> getEmployeeById(Long empId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(empId);
        return employeeEntity.map(employee -> modelMapper.map(employee,EmployeeDto.class));
    }
}
