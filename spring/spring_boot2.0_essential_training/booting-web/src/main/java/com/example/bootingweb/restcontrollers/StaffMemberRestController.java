package com.example.bootingweb.restcontrollers;

import com.example.bootingweb.models.StaffMember;
import com.example.bootingweb.services.StaffMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffMemberRestController {
    private final StaffMemberService staffMemberService;

    // constructor //@Autowired - since this is my only constructor;
    // no explicit auto wiring is required. Spring does that automatically
    public StaffMemberRestController(StaffMemberService staffMemberService) {
        this.staffMemberService = staffMemberService;
    }

    // get all the staff member list
    @GetMapping("/staffs")
    public List<StaffMember> getAllStaffMemberDetails(){
        List<StaffMember> staffMemberList = this.staffMemberService.getStaffMemberDetails();
        staffMemberList.sort(Comparator.comparing(StaffMember::getEmpLastName));
        return staffMemberList;
    }

}
