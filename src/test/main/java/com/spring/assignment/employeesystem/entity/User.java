package com.spring.assignment.employeesystem.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "empid")
    int empid;
    @Column(name = "username")
    String userName;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    String role;





    public User(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }



    public User(int id, String username, String password, String role) {
        this.empid=id;
        this.userName = username;
        this.password=password;
        this.password = password;
        this.role = role;
    }

}
