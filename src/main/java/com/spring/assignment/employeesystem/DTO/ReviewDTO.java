package com.spring.assignment.employeesystem.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Getter
@Setter
public class ReviewDTO {
    int id;

    int empId;
    @NotNull
    @Size(min = 1, message = "please don't leave it empty")
    String username;

    Date date;
    @NotNull
    @Size(min = 1, message = "please don't leave it empty")
    String reviews;
    public ReviewDTO(){}

    public ReviewDTO(int empId, @NotNull @Size(min = 1, message = "please don't leave it empty") String username, Date date, @NotNull @Size(min = 1, message = "please don't leave it empty") String review) {
        this.empId = empId;
        this.username = username;
        this.date = date;
        this.reviews = review;
    }

    public ReviewDTO(String username, Date date, String review) {

        this.username=username;
        this.date = date;
        this.reviews = review;
    }


}
