package com.spring.assignment.employeesystem.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@Setter
public class UserDTO {
        int id;
    int empid;
    String userName;
    String password;
    String role;



    public UserDTO() {
    }

    public UserDTO(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }



    public UserDTO(int id, String username, String password, String role) {
        this.empid=id;
        this.userName = username;
        this.password=password;
        this.password = password;
        this.role = role;
    }

}
