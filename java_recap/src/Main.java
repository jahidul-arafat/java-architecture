import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.TransferQueue;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Triangle Operations");
//        Triangle trA = new Triangle(2,10,5,5,5);
//        Triangle trB = new Triangle(10,20,10,10,10);
//
//        System.out.println("Triangle A Area: "+ trA.findArea());
//        System.out.println("Triangle B Area: "+ trB.findArea());
//
//        System.out.println("Demo Class Method: "+ Triangle.myClassMethod("DemoClassMethod"));
//        System.out.println("Triangle_A:\n--------------\n "+trA);
//        System.out.println("Triangle_B:\n--------------\n "+trB);

        System.out.println(args[0]);
        System.out.println("Student Info");
        Student stdA = new Student("Jahidul", "Arafat", LocalDate.now(),3.99,"CSE");
        System.out.println(stdA);

        String tempVar = "Dummy Data";
        tempVar = null;
        System.out.println(tempVar);

        System.gc();







    }
}
