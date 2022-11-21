package com.example.bootingweb.controllers;

import com.example.bootingweb.models.StaffMember;
import com.example.bootingweb.services.StaffMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    // Create 10x dummy staff
    // remember: this to a Class attribute, not Instance attribute
    private final StaffMemberService staffMemberService;

    // constructor
    public StaffController(StaffMemberService staffMemberService) {
        this.staffMemberService = staffMemberService;
    }

    // Controller will call the template
    @GetMapping
    public String getAllStaffMembers(Model model){
        List<StaffMember> staffMemberList = this.staffMemberService.getStaffMemberDetails();
        staffMemberList.sort(Comparator.comparing(StaffMember::getEmpLastName));
        model.addAttribute("staffMemberDetails",staffMemberList);
        return "staffs"; // calling the staffs.html
    }


    // return these dummy staff to the view to list them in a webpage template
    // next, design the webpage template in thymeleaf
}
