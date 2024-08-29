package com.example.Testing.EmployeeTest.controller;

import com.example.Testing.EmployeeTest.dto.EmployeeDto;
import com.example.Testing.EmployeeTest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    private EmployeeDto createNewEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createNewEmployee(employeeDto);
    }

    @GetMapping
    private List<EmployeeDto> getEmployee(){
        return employeeService.getEmployee();
    }

    @GetMapping(path = "/empId")
    private Optional<EmployeeDto> getEmployeeId(@PathVariable Long empId){
        return employeeService.getEmployeeById(empId);
    }
}
