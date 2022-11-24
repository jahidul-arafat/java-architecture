package com.example.bootingweb.restcontrollers;

import com.example.bootingweb.models.Employee;
import com.example.bootingweb.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    // constructor //@Autowired - since this is my only constructor;
    // no explicit auto wiring is required. Spring does that automatically
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get all the staff member list
    @GetMapping("/staff")
    public List<Employee> getEmployeeDetails(){
        List<Employee> employeeList = this.employeeService.getEmployeeDetails();
        return employeeList;
    }

}
