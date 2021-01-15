package com.spring.assignment.employeesystem.entity;

import com.spring.assignment.employeesystem.annotation.Unique;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Size(min = 1, message = "name should not be empty")
    @Column(name = "username")
    @Unique(message = "user alredy exists in db")
    String username;
    @NotNull
    @Size(min = 1, message = "role should not be empty")
    @Column(name = "role")
    String role;
    @NotNull
    @Size(min = 1, message = "project should not be empty")
    @Column(name = "projectname")
    String project;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    List<Review> reviewList;


    public Employee() {

    }

    public Employee(String username, String role, String project) {
        this.username = username;
        this.role = role;
        this.project = project;
    }
    public Employee(int id, String username, String role, String project) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.project = project;
    }

    public void addReview(Review tempreview) {
        if(reviewList==null)
            reviewList=new ArrayList<>();
        reviewList.add(tempreview);
        reviewList.add(tempreview);

    }

}
