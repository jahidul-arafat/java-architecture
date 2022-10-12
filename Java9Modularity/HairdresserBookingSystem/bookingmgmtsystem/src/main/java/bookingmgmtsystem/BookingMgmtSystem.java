package bookingmgmtsystem;

import customers.Customer;
import employees.Hairdresser;
import scheduling.Scheduler;

public class BookingMgmtSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to booking system");

        // create customers
        Customer billy = new Customer("Billy");
        Customer cilly = new Customer("Cilly");
        Customer dilly = new Customer("Dilly");
        Customer eilly = new Customer("Eilly");
        Customer filly = new Customer("Filly");
        Customer gilly = new Customer("Gilly");
        Customer hilly = new Customer("Hilly");


        Scheduler sc = new Scheduler();


        sc.bookHaircut(billy,"Harry", "Monday");
        sc.bookHaircut(cilly,"Harry", "Tuesday");
        sc.bookHaircut(dilly,"Harry", "Monday");
        sc.bookHaircut(eilly,"Harry", "Tuesday");
        sc.bookHaircut(filly,"Harry", "Monday");
        sc.bookHaircut(gilly,"Harry", "Tuesday");
        sc.bookHaircut(billy,"Harry", "Monday");
        sc.bookHaircut(cilly,"Harry", "Tuesday");
        sc.bookHaircut(dilly,"Harry", "Monday");
        sc.bookHaircut(eilly,"Harry", "Tuesday");

        sc.bookHaircut(filly,"Harry", "Monday"); // fail to book
        sc.bookHaircut(gilly,"Harry", "Tuesday"); // fail to book


        sc.bookHaircut(hilly,"Jill","Wednesday");

    }
}
