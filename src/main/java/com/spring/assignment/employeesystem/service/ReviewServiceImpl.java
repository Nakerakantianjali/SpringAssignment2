package com.spring.assignment.employeesystem.service;

import com.spring.assignment.employeesystem.dao.ReviewRepository;
import com.spring.assignment.employeesystem.entity.Review;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Log
@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;
    @Autowired
    ReviewServiceImpl(ReviewRepository reviewRepository){
       this.reviewRepository=reviewRepository;
    }
    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }



    @Override
    public List<Review> findByEmpId(int empId) {

    log.info("your review"+ reviewRepository.findByEmpId(empId));


            return reviewRepository.findByEmpId(empId);

    }

    @Override
    public void deleteByEmpId(int empId) {
        List<Review>reviewList= reviewRepository.findByEmpId(empId);
        reviewRepository.deleteAll(reviewList);

    }

}
