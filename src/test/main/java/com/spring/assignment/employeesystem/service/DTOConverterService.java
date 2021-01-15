package com.spring.assignment.employeesystem.service;

import com.spring.assignment.employeesystem.DTO.EmployeeDTO;
import com.spring.assignment.employeesystem.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOConverterService {

    private ModelMapper modelMapper;
    @Autowired
    public DTOConverterService(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }
    public Employee mapper(EmployeeDTO employee){

      return   modelMapper.map(employee,Employee.class);
    }
}
