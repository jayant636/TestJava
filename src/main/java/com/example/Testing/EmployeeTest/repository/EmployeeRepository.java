package com.example.Testing.EmployeeTest.repository;

import com.example.Testing.EmployeeTest.entity.EmployeeEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    List<EmployeeEntity> findByEmail(String email);
}
