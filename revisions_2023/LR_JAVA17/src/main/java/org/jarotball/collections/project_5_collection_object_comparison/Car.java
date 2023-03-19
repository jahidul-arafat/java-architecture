package org.jarotball.collections.project_5_collection_object_comparison;

import java.util.Objects;

public class Car {
    // Instance Attributes
    private final String make, model;
    private int mileage;


    // Constructor
    public Car(String make, String model, int mileage) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
    }

    // Getter - No Setter

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    // override equals() for value-based comparison instead of instance-based comparison

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        System.out.format("Comparing %s<<>>%s with %s<<>>%s%n",
                this.make,this.model,car.make,car.model);

        if (!Objects.equals(make, car.make)) return false;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    // Print the object

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", mileage='" + mileage + '\'' +
                '}';
    }
}
