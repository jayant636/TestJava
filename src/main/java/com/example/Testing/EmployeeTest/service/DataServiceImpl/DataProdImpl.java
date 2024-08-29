package com.example.Testing.EmployeeTest.service.DataServiceImpl;

import com.example.Testing.EmployeeTest.service.DataService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Prod")
public class DataProdImpl implements DataService {
    @Override
    public String getData() {
        return "Prod Data";
    }
}
