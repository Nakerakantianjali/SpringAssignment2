package com.spring.assignment.employeesystem.service;

import com.spring.assignment.employeesystem.DTO.EmployeeDTO;
import com.spring.assignment.employeesystem.dao.EmployeeRepository;
import com.spring.assignment.employeesystem.dao.ReviewRepository;
import com.spring.assignment.employeesystem.dao.UserRepository;
import com.spring.assignment.employeesystem.entity.Employee;
import com.spring.assignment.employeesystem.entity.Review;
import com.spring.assignment.employeesystem.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements  EmployeeService{
    EmployeeRepository employeeRepository;
    UserRepository userRepository;
    ReviewRepository reviewRepository;
    @Autowired
    public  EmployeeServiceImpl(EmployeeRepository employeeRepository,UserRepository userRepository,ReviewRepository reviewRepository){
        this.employeeRepository=employeeRepository;
        this.userRepository=userRepository;
        this.reviewRepository=reviewRepository;

    }

    @Override
    public List<Employee> findAll() {
       return  employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id).get();
    }
    @Override
    public Employee save(EmployeeDTO employee) {
        String password="test123";
        Employee employee1=new Employee();
        employee1.setUsername(employee.getUsername());
        employee1.setRole(employee.getRole());
        employee1.setProject(employee.getProject());
        employeeRepository.save(employee1);
        Optional<List<Employee>> employee2=  employeeRepository.findByUsername(employee.getUsername());
          System.out.println("my employe-->"+employee2.get());
       User user =new User(employee2.get().get(0).getId(),employee2.get().get(0).getUsername(),password,employee2.get().get(0).getRole());
       userRepository.save(user);
       return employee1;

    }


    @Override
    public Employee update(EmployeeDTO employee) {
       Employee employee1=employeeRepository.findById(employee.getId()).get();
       employee1.setProject(employee.getProject());
       employee1.setRole(employee.getRole());
        employeeRepository.save(employee1);
        User user=userRepository.findByEmpid(employee1.getId()).get();
        user.setRole(employee.getRole());
        userRepository.save(user);

        return employee1;
    }

    @Override
    public void deleteById(int id) {
        List<Review>reviewList=reviewRepository.findByEmpId(id);
        if(reviewList.size()>0) {
            reviewRepository.deleteAll(reviewList);
        }
        employeeRepository.deleteById(id);

    }

    @Override
    public List<Employee> findByUsername(String username) {

        return employeeRepository.findByUsername(username).get();
    }

    @Override
    public List<Employee> findByProject(int id) {

        Employee employee=employeeRepository.findById(id).get();
        return employeeRepository.findByProject(employee.getProject()).get();


    }

    @Override
    public List<Employee> findByProjectName(String username) {
       List< Employee> employee=  employeeRepository.findByUsername(username).get();
        return employeeRepository.findByProject(employee.get(0).getProject()).get();

    }

    @Override
    public boolean existsByUsername(String username) {
        return employeeRepository.existsByUsername(username);
    }
}
