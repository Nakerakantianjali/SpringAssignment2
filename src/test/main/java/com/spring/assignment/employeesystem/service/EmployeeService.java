package com.spring.assignment.employeesystem.service;

import com.spring.assignment.employeesystem.DTO.EmployeeDTO;
import com.spring.assignment.employeesystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
     List<Employee> findAll();
     Employee findEmployeeById(int id);
     Employee save(EmployeeDTO employee);
     Employee update(EmployeeDTO employee);
     void deleteById(int id);
     List<Employee> findByUsername(String firstName);
     List<Employee> findByProject(int id );
     List<Employee> findByProjectName(String username );
     boolean existsByUsername(String username);
}
