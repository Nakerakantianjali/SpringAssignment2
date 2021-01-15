package com.spring.assignment.employeesystem.dao;

import com.spring.assignment.employeesystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
    Optional<List<Review>> getReviewById(int id);
    List<Review>findByEmpId(int empId);
}
