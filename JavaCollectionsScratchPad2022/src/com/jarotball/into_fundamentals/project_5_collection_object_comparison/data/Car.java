package com.jarotball.into_fundamentals.project_5_collection_object_comparison.data;

import java.util.Objects;

public class Car {
    private final String make;
    private final String model;
    private final int mileage;

    // Constructor
    public Car(String make, String model, int mileage) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
    }

    // Getter

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    // override the equals to convert it to value-comparison instead instance-comparison
    // when overriding the equals() as a convention hashCode() will also be overriden
    /*
    * Strategy for Object equivalence <VALUE-BASED-COMPARISON> / Default is <INSTANCE-BASED COMPARISON>
    * - Choose the fields which don't change frequently; here in the Car object <make, model>; I have ignored mileage as this would change
    * - now based on these two <make, model>, we will compare the car objects whether they are same means having same make and model name.
    * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        System.out.format("Comparing %s %s with %s %s %n",
                this.make, this.model, car.make,car.model);

        if (!Objects.equals(make, car.make)) return false;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    // Print the Object
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }


}
