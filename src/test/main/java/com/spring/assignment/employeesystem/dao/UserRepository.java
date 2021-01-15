package com.spring.assignment.employeesystem.dao;

import com.spring.assignment.employeesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
    User findByEmpid(int empid);




}
