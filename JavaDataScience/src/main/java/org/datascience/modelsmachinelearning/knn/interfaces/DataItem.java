package org.datascience.modelsmachinelearning.knn.interfaces;

import java.util.List;

public interface DataItem {
    public List<Double> getCoordinates();   // For FlowerRecord, this will return List of {sepalLength, sepalWidth, petalLength, petalWidth}
    public String getClassifier();          // For FlowerRecord, this will return the Species name i.e. Iris-setosa
}
