package com.spring.assignment.employeesystem.controller;

import com.spring.assignment.employeesystem.DTO.EmployeeDTO;
import com.spring.assignment.employeesystem.config.Userdetails;
import com.spring.assignment.employeesystem.entity.Employee;
import com.spring.assignment.employeesystem.entity.Review;
import com.spring.assignment.employeesystem.service.EmployeeService;
import com.spring.assignment.employeesystem.service.MyUserServices;
import com.spring.assignment.employeesystem.service.ReviewService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employee")
@Log
public class EmployeeController {
    private String employeeLiteral="employee";
    private String employeeListLiteral="employeeList";
    private  String redirectLiteral="redirect:/employee/list";
    private List<Employee> employeeList;
    EmployeeService employeeService;
    ReviewService reviewService;
    MyUserServices myUserServices;
    @Autowired
    public EmployeeController(EmployeeService employeeService, ReviewService reviewService,MyUserServices myUserServices){
        this.employeeService=employeeService;
        this.reviewService=reviewService;
        this.myUserServices=myUserServices;
    }
    @RequestMapping(value = "/home")
    public String home(){
        return "homepage";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name=authentication.getName();
         employeeList = employeeService.findByUsername(name);

        Employee employee1=employeeList.get(0);
        model.addAttribute(employeeLiteral,employee1);

        return "profile";
    }

    @RequestMapping("/list")
    public  String employeeList(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info(""+ authentication.getAuthorities());
        Userdetails userdetails= (Userdetails) authentication.getPrincipal();
        String listEmployees="list-employees";

                employeeList = employeeService.findAll();
                model.addAttribute(employeeListLiteral, employeeList);
        if(userdetails.getRole().equals("TeamLead")){

                employeeList = employeeService.findByProjectName(userdetails.getUsername());
                model.addAttribute(employeeListLiteral, employeeList);

        }
        return listEmployees;
    }
    @GetMapping("/showFormForAdd")
    public String showFormforAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int empid,Model model){
        Employee employee=employeeService.findEmployeeById(empid);
        model.addAttribute(employeeLiteral,employee);
        return "employee--update-form";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") EmployeeDTO employee, BindingResult bindingResult, Model model){

        if(!bindingResult.hasErrors()){
            employeeService.save(employee);
            return redirectLiteral;

        }

        model.addAttribute(employeeLiteral,employee);

        return "employee-form";


    }
    @PostMapping("/save1")
    public String save1(@Valid @ModelAttribute("employee") EmployeeDTO employee, BindingResult bindingResult,Model model){

        if(!bindingResult.hasErrors()){
            Employee employee1=employeeService.findEmployeeById(employee.getId());
            employee.setUsername(employee1.getUsername());
            employeeService.update(employee);
            log.info("--->empsaved");
            return redirectLiteral;

        }


        log.info("----->pelease fill all the fileds");
        model.addAttribute(employeeLiteral,employee);

        return "employee--update-form";


    }
    @GetMapping("/delete")
    public String showFormForDelete(@RequestParam("employeeId") int empid){
        Employee employee=employeeService.findEmployeeById(empid);
        reviewService.deleteByEmpId(empid);
        myUserServices.delete(employee.getUsername());
        employeeService.deleteById(empid);
        return "redirect:/employee/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam("username")String username, Model model){
        employeeList=employeeService.findByUsername(username);
        model.addAttribute(employeeListLiteral,employeeList);
        return "list-employees";
    }

    @GetMapping("/project")
    public String findByProject(@RequestParam("employeeId")int id, Model model, Principal principal){

        employeeList=employeeService.findByProject(id);
        model.addAttribute(employeeLiteral,employeeList);
        return "list-employees2";
    }
    @RequestMapping("/addReview")
    public String addReview(@RequestParam("employeeId")int id,Model model){
              Employee employee=employeeService.findEmployeeById(id);
        model.addAttribute(employeeLiteral,employee);
        return "details";
    }
    @RequestMapping("/saveReview")
    public String saveReview(@RequestParam("review")String reviews,@ModelAttribute("employee")EmployeeDTO employee,Model model){
        Date date= new Date();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Userdetails userdetails = (Userdetails) authentication.getPrincipal();
        log.info("-->user details:{}"+userdetails);
        Review review = new Review(employee.getId(),date,reviews);
        reviewService.addReview(review);


        model.addAttribute(employeeLiteral,employee);
          return "details";
    }
    @RequestMapping("/checkReview")
    public String checkReview(@ModelAttribute("employee")EmployeeDTO employeeDTO, Model model){
        List<Review>reviewList=reviewService.findByEmpId(employeeDTO.getId());

        model.addAttribute("reviewList",reviewList);



        return "review-list.html";
    }

}
