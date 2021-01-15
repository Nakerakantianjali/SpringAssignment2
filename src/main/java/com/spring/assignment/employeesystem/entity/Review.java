package com.spring.assignment.employeesystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Table(name = "review")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "employee_id")
    int empId;

    @Column(name = "username")
    @NotNull
    @Size(min = 1, message = "please don't leave it empty")
    String username;
    @Column(name = "date")

    Date date;
    @NotNull
    @Size(min = 1, message = "please don't leave it empty")
    @Column(name = "review")
    String reviews;
    public Review(){}

    public Review(int empId, @NotNull @Size(min = 1, message = "please don't leave it empty") String username, Date date, @NotNull @Size(min = 1, message = "please don't leave it empty") String review) {
        this.empId = empId;
        this.username = username;
        this.date = date;
        this.reviews = review;
    }

    public Review(String username, Date date, String review) {

        this.username=username;
        this.date = date;
        this.reviews = review;
    }


    }
