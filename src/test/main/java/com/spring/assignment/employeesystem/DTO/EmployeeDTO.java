package com.spring.assignment.employeesystem.DTO;

import com.spring.assignment.employeesystem.annotation.Unique;
import com.spring.assignment.employeesystem.entity.Review;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
   private   int id;
    @Size(min = 1, message = "name should not be empty")
    @Unique(message = "user alredy exists in db")
    @Getter
    @Setter

     private String username;
    @NotNull
    @Size(min = 1, message = "role should not be empty")
    private String role;
    @NotNull
    @Size(min = 1, message = "project should not be empty")
    String project;
    public EmployeeDTO(int id, String username, String role, String project) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.project = project;
    }

    List<Review> reviewList;



}

