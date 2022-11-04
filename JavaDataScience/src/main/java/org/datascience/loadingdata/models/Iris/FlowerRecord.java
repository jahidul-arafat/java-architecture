package org.datascience.loadingdata.models.Iris;

import org.datascience.modelsmachinelearning.knn.interfaces.DataItem;

import java.util.Arrays;
import java.util.List;

public class FlowerRecord implements DataItem {
    private final Double sepalLength;
    private final Double sepalWidth;
    private final Double petalLength;
    private final Double petalWidth;
    private final String species;

    // constructor
    public FlowerRecord(Double sepalLength, Double sepalWidth, Double petalLength, Double petalWidth, String species) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }

    // Getter ------------------------------------
    public Double getSepalLength() {
        return sepalLength;
    }

    public Double getSepalWidth() {
        return sepalWidth;
    }

    public Double getPetalLength() {
        return petalLength;
    }

    public Double getPetalWidth() {
        return petalWidth;
    }

    public String getSpecies() {
        return species;
    }
    //-----------------------------------------------

    // Print the object
    @Override
    public String toString() {
        return "FlowerRecord{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                ", species='" + species + '\'' +
                '}';
    }

    @Override
    public List<Double> getCoordinates() {
        return Arrays.asList(this.sepalLength,this.sepalWidth,this.petalLength,this.petalWidth);
    }

    @Override
    public String getClassifier() {
        return this.species;
    }
}
