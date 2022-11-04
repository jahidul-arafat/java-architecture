package org.datascience.modelsmachinelearning.knn.utils;

import org.datascience.modelsmachinelearning.knn.interfaces.DataItem;

import java.util.List;

/**
 * Take two data items as argument and return the distance between them
 */
public class DataItemUtil {
    public static Double getDistance(DataItem item1, DataItem item2){
        var item1Coordinates = item1.getCoordinates(); // flower1: {sepalLength1.1, sepalWidth1.2, petalLength1.3, petalWidth1.4}
        var item2Coordinates = item2.getCoordinates(); // flower2: {sepalLength2.1, sepalWidth2.2, petalLength2.3, petalWidth2.4}

        // iterate through the dataItems elements in the list and find the distance between them
        /*
        * Math.sqrt{(sepalLength1.1 - sepalLength2.1)^2 +
        * (sepalWidth1.2 - sepalWidth2.2)^2   +
        * (petalLength1.3 - petalLength2.3)^2 +
        * (petalWidth1.4 - petalWidth2.4)^2}
        *
        * Formula: PQ=√ {(x2−x1)^2+(y2−y1)^2}
        * */

        Double sum=0d;
        for (int i = 0; i < item1Coordinates.size(); i++) {
            Double dimensionDistance = item2Coordinates.get(i) - item1Coordinates.get(i);
            sum += dimensionDistance*dimensionDistance;
        }

        return Math.sqrt(sum);


    }
}
