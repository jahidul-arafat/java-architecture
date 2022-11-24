package com.example.bootingweb.services;

import com.example.bootingweb.helpers.Helper;
import com.example.bootingweb.models.Position;
import com.example.bootingweb.models.Employee;
import com.example.bootingweb.repositoreis.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
//    private final List<Employee> employeeList = Arrays.asList(
//            new Employee(UUID.randomUUID().toString(),"Billy","Bow", Position.SECURITY.toString()),
//            new Employee(UUID.randomUUID().toString(),"Alliy","Aow", Position.HOUSEKEEPING.toString()),
//            new Employee(UUID.randomUUID().toString(),"Cilly","Cow", Position.CONCIERGE.toString()),
//            new Employee(UUID.randomUUID().toString(),"Dilly","Dow", Position.FRONT_DESK.toString())
//    );

    // constructor
//    public StaffMemberService(List<StaffMember> staffMemberList) {
//        this.staffMemberList = staffMemberList;
//    }

    // instance methods
    // setTheStaffMember
    //getTheStaffMember

//    public void setStaffMemberDetails(){
//         this.staffMemberList.add(new StaffMember(UUID.randomUUID().toString(),"Billy","Bow", Position.SECURITY.toString()));
//         this.staffMemberList.add(new StaffMember(UUID.randomUUID().toString(),"Alliy","Aow", Position.HOUSEKEEPING.toString()));
//         this.staffMemberList.add(new StaffMember(UUID.randomUUID().toString(),"Cilly","Cow", Position.CONCIERGE.toString()));
//         this.staffMemberList.add(new StaffMember(UUID.randomUUID().toString(),"Dilly","Dow", Position.FRONT_DESK.toString()));
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeDetails(){

        // get all the employees
        var empIterables = this.employeeRepository.findAll();

        // covert the iterable into a list
        List<Employee> empList = Helper.covertInterableIntoList(empIterables);
        empList.sort(Comparator.comparing(Employee::getEmpLastName));
        System.out.println(empList);
        return empList;
    }
}
