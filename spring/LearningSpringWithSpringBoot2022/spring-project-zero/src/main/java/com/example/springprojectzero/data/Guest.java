package com.example.springprojectzero.data;

import javax.persistence.*;

@Entity
@Table(name = "GUEST")
public class Guest {
    /*

  GUEST_ID BIGSERIAL PRIMARY KEY,
  FIRST_NAME VARCHAR(64),
  LAST_NAME VARCHAR(64),
  EMAIL_ADDRESS VARCHAR(64),
  ADDRESS VARCHAR(64),
  COUNTRY VARCHAR(32),
  STATE VARCHAR(12),
  PHONE_NUMBER VARCHAR(24)

     */

    // Instance Attributes

    // // GeneraitonType.AUTO would not work if we are trying to add a new Guest from our program
    // This gonna break if used GenerationType.AUTO; thats what I have seen from my earlier exection while trying to add a new guest, which returns new guest ID=0
    // in GenerationType.AUTO -> sequence of our database doenst matter and Auto worked fine
    // But since we are adding, we need to have some way to generate the ID
    // Solution: Use GenerationType.IDENTITY because thats works with H2 Spring embedded database
    // if this is a Oracle Database, we have to use GenerationType.SEQUENCE and then we have to point to the name of that sequence
    // If AUTO used-> Error (when trying to add a new guest into the list): Caused by: org.hibernate.exception.SQLGrammarException: could not prepare statement
    @Id
    @Column(name = "GUEST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL_ADDRESS")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    // constructor - not required as data will be loaded directly from embedded database into Spring Boot framework

    // getter and setter
    // you can even use Lomboks, if you want to create getter and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    // Print the Object

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
