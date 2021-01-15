package com.spring.assignment.employeesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/")
   public String welcome(){
        return "welcome";
    }
    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping("/acess-denied")
    public String error() {
        return "error";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }


}
