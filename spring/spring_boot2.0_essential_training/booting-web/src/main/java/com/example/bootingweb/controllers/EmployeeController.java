package com.example.bootingweb.controllers;

import com.example.bootingweb.models.Employee;
import com.example.bootingweb.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class EmployeeController {
    // Create 10x dummy staff
    // remember: this to a Class attribute, not Instance attribute
    private final EmployeeService employeeService;

    // constructor
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Controller will call the template
    @GetMapping("/details")
    public String getEmployeeDetails(Model model){
        List<Employee> employeeList = this.employeeService.getEmployeeDetails();
        model.addAttribute("employeeDetails", employeeList);
        return "staffs"; // calling the staffs.html
    }


    // return these dummy staff to the view to list them in a webpage template
    // next, design the webpage template in thymeleaf
}
