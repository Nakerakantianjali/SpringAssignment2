package com.spring.assignment.employeesystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
        int id;
    int empid;
    String userName;
    String password;
    String role;




    public UserDTO(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }




}
