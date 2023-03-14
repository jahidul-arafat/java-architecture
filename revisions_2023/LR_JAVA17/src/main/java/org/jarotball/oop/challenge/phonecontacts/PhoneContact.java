package org.jarotball.oop.challenge.phonecontacts;

import org.jetbrains.annotations.NotNull;

public class PhoneContact extends Contact{
    String phNumber, email;


    // Constructors
    // Constructor-01: Compile Time Polymorphism
    public PhoneContact(String name, String address, String phNumber) {
        super(name, address);
        this.phNumber = phNumber;
    }

    // Constructor-02: Compile Time Polymorphism
    public PhoneContact(String name, String address, String phNumber, String email) {
        super(name, address);
        this.phNumber = phNumber;
        this.email = email;
    }

    // Constructor-03: Compile Time Polymorphism
    public PhoneContact(@NotNull Contact contact, String phNumber, String email) {
        super(contact.getName(), contact.getAddress());
        this.phNumber = phNumber;
        this.email = email;
    }

    // Constructor-03: Compile Time Polymorphism

    

    // ----------------------------------------------------------------------------------------------------------\\
    // Special Methods - Only accessible to the PhoneContact instances, not available for Contact Instances
    // Instance Methods
    public void assignASpecialNumber(){
        this.phNumber = "01711511611";
        this.email = "special@special.com";
    }

    // ----------------------------------------------------------------------------------------------------------\\

    // Getter and Setter
    public String getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // Print the Object


    @Override
    public String toString() {
        return "PhoneContact{" +
                super.toString()+ " " +
                "phNumber='" + phNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
