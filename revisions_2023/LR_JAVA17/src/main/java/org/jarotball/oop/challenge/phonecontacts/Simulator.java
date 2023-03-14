package org.jarotball.oop.challenge.phonecontacts;

public class Simulator {

    public static void specialSpell(Contact contact){
        if (contact instanceof PhoneContact){
            System.out.println("Applying Special Spell ....");
            PhoneContact phoneContact = (PhoneContact) contact;
            phoneContact.assignASpecialNumber();
        } else{
            System.out.println("No Special Spell Applied !!!");
        }

    }
    public static void main(String[] args) {
        Contact contact1 = new Contact("Alice", "Dhaka");
        System.out.println(contact1);
        specialSpell(contact1);
        System.out.println(contact1);
        System.out.println();

        PhoneContact phoneContact1 = new PhoneContact(contact1,"01273","abc@xyz.com");
        System.out.println(phoneContact1);
        specialSpell(phoneContact1);
        System.out.println(phoneContact1);
        System.out.println();

        PhoneContact phoneContact2= new PhoneContact("Bob","Cumilla", "017234567");
        System.out.println(phoneContact2);


    }
}
