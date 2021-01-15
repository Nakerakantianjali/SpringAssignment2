package com.spring.assignment.employeesystem.dao;

import com.spring.assignment.employeesystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<List<Employee>> findByUsername(String username);
   Optional< Employee> findById(int id);
    Optional<List<Employee>> findByProject(String project );
    Boolean existsByUsername(String username);


}
