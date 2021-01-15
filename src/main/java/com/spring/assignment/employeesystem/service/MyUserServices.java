package com.spring.assignment.employeesystem.service;

import com.spring.assignment.employeesystem.config.Userdetails;
import com.spring.assignment.employeesystem.dao.UserRepository;
import com.spring.assignment.employeesystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserServices implements UserDetailsService {
    UserRepository userRepository;
    @Autowired
    public MyUserServices(UserRepository userRepository){

        this.userRepository=userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       User user =userRepository.findByUserName(userName).get();

       if(user==null){
           throw  new UsernameNotFoundException("user not found");
       }
        return new Userdetails(user);
    }
    public  void delete( String username)throws UsernameNotFoundException{

        User user =userRepository.findByUserName(username).get();
        if(user != null) {
            userRepository.delete(user);
        }
    }
    public  User findByUser(String name){
        return userRepository.findByUserName(name).get();
    }
    public  User findByEmpid(int empid){
        return userRepository.findByEmpid(empid).get();
    }
}


