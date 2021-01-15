package com.spring.assignment.employeesystem.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "employee_id")
    int empId;


    @Column(name = "date")

    Date date;
    @NotNull
    @Size(min = 1, message = "please don't leave it empty")
    @Column(name = "review")
    String reviews;
    public Review(int empid, Date date, String reviews) {
        this.empId=empid;
        this.date=date;
        this.reviews=reviews;
    }


}
