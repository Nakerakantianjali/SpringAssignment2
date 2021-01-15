package com.spring.assignment.employeesystem.annotation;

import com.spring.assignment.employeesystem.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class UserUniqueValidator implements ConstraintValidator<Unique,String> {

   private EmployeeRepository employeeRepository;
    public UserUniqueValidator(){}

    @Autowired
    public UserUniqueValidator(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }


    @Override
    public void initialize(Unique constraintAnnotation) {
        constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {

        if(employeeRepository!=null) {
           boolean flag = employeeRepository.existsByUsername(username);

            if(flag) {
                return false;
            }
            return  true;
        }


     return true;
    }
}
