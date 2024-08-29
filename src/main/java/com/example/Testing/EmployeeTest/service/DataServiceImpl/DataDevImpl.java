package com.example.Testing.EmployeeTest.service.DataServiceImpl;

import com.example.Testing.EmployeeTest.service.DataService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Dev")
public class DataDevImpl implements DataService {
    @Override
    public String getData() {
        return "Dev Data";
    }
}
