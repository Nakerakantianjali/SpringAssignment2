package com.spring.assignment.employeesystem.dao;

import com.spring.assignment.employeesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByEmpid(int empid);




}
