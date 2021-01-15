package com.spring.assignment.employeesystem.service;

import com.spring.assignment.employeesystem.entity.Review;

import java.util.List;

public interface ReviewService {
      void addReview(Review review);
     List<Review> findByUserName(String username);
     void deleteByName(String username);
     List<Review>  findByEmpId(int empId);

}
