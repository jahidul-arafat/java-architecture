package org.datascience.loadingdata.models.Census;

public class PersonRecord {
    public final Integer age;
    public final String employmentStatus;
    public final String education;


    // constructor
    public PersonRecord(Integer age, String employmentStatus, String education) {
        this.age = age;
        this.employmentStatus = employmentStatus;
        this.education = education;
    }

    // Print the Object

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
