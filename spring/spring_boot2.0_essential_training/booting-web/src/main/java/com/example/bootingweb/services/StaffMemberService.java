package com.example.bootingweb.services;

import com.example.bootingweb.models.Position;
import com.example.bootingweb.models.StaffMember;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StaffMemberService {
    private final List<StaffMember> staffMemberList;

    // constructor
    public StaffMemberService(List<StaffMember> staffMemberList) {
        this.staffMemberList = staffMemberList;
    }

    // instance methods
    // setTheStaffMember
    //getTheStaffMember

    public void setStaffMemberDetails(){
         this.staffMemberList.add(new StaffMember(UUID.randomUUID().toString(),"Billy","Bow", Position.SECURITY.toString()));
         this.staffMemberList.add(new StaffMember(UUID.randomUUID().toString(),"Alliy","Aow", Position.HOUSEKEEPING.toString()));
         this.staffMemberList.add(new StaffMember(UUID.randomUUID().toString(),"Cilly","Cow", Position.CONCIERGE.toString()));
         this.staffMemberList.add(new StaffMember(UUID.randomUUID().toString(),"Dilly","Dow", Position.FRONT_DESK.toString()));
    }

    public List<StaffMember> getStaffMemberDetails(){
        this.setStaffMemberDetails();
        return this.staffMemberList;
    }
}
