package org.jarotball.oop.inheritance_problem1;

public class simulator {
    public static void main(String[] args) {
        // Salesperson
        Salesperson salesperson1 = new Salesperson("Alice", 1000.23,23, 0.45);
        Salesperson salesperson2 = new Salesperson("Bob", 500.23,27, 0.28);

        salesperson1.raiseSalary();
        salesperson1.raiseCommission();

        System.out.println(salesperson1);
        System.out.println(salesperson2);

        // Analyst
        Analyst analyst1 = new Analyst("Alice",1000,23);
        Analyst analyst2 = new Analyst("Bob", 500, 28);

        System.out.format("%s annual bonus %s%n",analyst1.getName(),analyst1.getAnnualBonus());
        System.out.format("%s annual bonus %s%n",analyst2.getName(),analyst2.getAnnualBonus());

        System.out.println(analyst1);
        System.out.println(analyst2);




    }
}
