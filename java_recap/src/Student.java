import java.time.LocalDate;

public class Student {

    // class variable
    private final static String universityName = "DemoUniversity";

    // instance variable -- private final makes it require getter+setter
    private final String firstName;
    private final String lastName;
    private final LocalDate yearOfGraduation;
    private final double gpa;
    private final String major;

    public Student(String firstName,
                   String lastName,
                   LocalDate yearOfGraduation,
                   double gpa,
                   String major)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfGraduation = yearOfGraduation;
        this.gpa = gpa;
        this.major = major;
    }

    // Overriding
    @Override
    public String toString(){
        String output = "Student Info\n----------------"+"\n"+
                "University: "+ universityName + "\n"+
                "Name: "+ this.firstName+" "+this.lastName+"\n"+
                "Graduation Year: "+ this.yearOfGraduation+"\n"+
                "GPA: "+ this.gpa+"\n"+
                "Major: "+ this.major+"\n";
        return output;
    }
}
