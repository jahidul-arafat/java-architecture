package customers;

import scheduling.Scheduler;

/**
 * customer will be able to use the booking system designed in the module <bookingsystem>
 * but, bookingsystem is in a different module than that of customer.
 * So, right bow, customer cant use the <bookingsystem></bookingsystem>
 *
 * Solution
 * 1. make the package<scheduling> available to other modules
 * */
public class Customer {
    public static void main(String[] args) {
        Scheduler sc = new Scheduler();
        sc.bookHaircut("HairDresser_01","Friday");
        sc.bookHaircut("HairDresser_01","Saturday");
        sc.bookHaircut("HairDresser_02","Wednesday");
        sc.bookHaircut("HairDresser_01","Monday");
        sc.bookHaircut("HairDresser_01","Tuesday");

    }
}




