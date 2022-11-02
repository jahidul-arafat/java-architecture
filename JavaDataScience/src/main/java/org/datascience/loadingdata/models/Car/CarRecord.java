package org.datascience.loadingdata.models.Car;

public class CarRecord {
    private final Float mpg;
    private final Integer numberOfCylinders;
    private final Float displacement;
    private final Float weight;


    // constructor
    public CarRecord(Float mpg, Integer numberOfCylinders, Float displacement, Float weight) {
        this.mpg = mpg;
        this.numberOfCylinders = numberOfCylinders;
        this.displacement = displacement;
        this.weight = weight;
    }

    // getter methods
    public Float getMpg() {
        return mpg;
    }

    public Integer getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public Float getDisplacement() {
        return displacement;
    }

    public Float getWeight() {
        return weight;
    }

    // Print the Object

    @Override
    public String toString() {
        return "CarRecord{" +
                "mpg=" + mpg +
                ", numberOfCylinders=" + numberOfCylinders +
                ", displacement=" + displacement +
                ", weight=" + weight +
                '}';
    }
}
