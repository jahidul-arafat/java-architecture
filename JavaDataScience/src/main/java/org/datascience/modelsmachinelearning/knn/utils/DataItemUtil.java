package org.datascience.modelsmachinelearning.knn.utils;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.datascience.modelsmachinelearning.knn.interfaces.DataItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Take two data items as argument and return the distance between them
 */
public class DataItemUtil {

    // for KNN
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

    // For NaiveBayes
    public  static List<Double> getColumnMeans(List<DataItem> dataItemList){
        List<Double> columnMeanList = new ArrayList<>();
        // traverse each column
        for (int i = 0; i < dataItemList.get(0).getCoordinates().size(); i++) {
            var finalI = i; // precaution // could be escaped
            var valuesOfAColumn = dataItemList
                    .stream()
                    .map(dataItem -> dataItem.getCoordinates().get(finalI))
                    .mapToDouble(Double::doubleValue)// covert the value into double
                    .toArray();
            var columnMean = StatUtils.mean(valuesOfAColumn); // StatUtils require (anArray)
            columnMeanList.add(columnMean);
        }

        System.out.println(columnMeanList);
        return columnMeanList;

    }

    public static List<Double> getColumnSDs(List<DataItem> dataItemList){
        List<Double> columnSDList = new ArrayList<>();

        // traverse each column
        // for each column, get all its data and calculate SD
        // repeat it for all the columns
        for (int i = 0; i < dataItemList.get(0).getCoordinates().size(); i++) {
            var finalI=i; // precaution // could be escaped
            var valuesOfAColumn = dataItemList
                    .stream()
                    .map(dataItem -> dataItem.getCoordinates().get(finalI))
                    .mapToDouble(Double::doubleValue)
                    .toArray();
            var columnSD = StatUtils.variance(valuesOfAColumn);
            columnSDList.add(columnSD);

        }

        System.out.println(columnSDList);
        return columnSDList;

    }

    public static Double getLabelProbabilityForNewDataPoint(List<Double> columnMeanList,
                                                            List<Double> columnSDList,
                                                            DataItem unlabelledDataItem){
        Double probability = 1.0;
        // travese through each dataPoint of the unlabelledDataItem, calcutate the probability of that respective data point
        // So if newDataItem (dp1,dp2,dp3, ... dpN), then finalProbability =
        //              probability(dp1) * probability(dp2) * probability(dp3) * ...... * probability(dpN)
        for (int i = 0; i < columnMeanList.size(); i++) {
            // fetch the values to compare against dataPointOfUnlabelledDataItem at that position
            var mean = columnMeanList.get(i);
            System.out.println("Mean: "+ mean);
            var sd = columnSDList.get(i);
            System.out.println("SD:"+ sd);
            var dataPointOfUnlabelledDataItem =unlabelledDataItem.getCoordinates().get(i);

            // Calculated the NormalDistribution with the mean and SD
            NormalDistribution dist = new NormalDistribution(mean,sd);

            // calculate the probability of the respective dataPoint of the unlabelledDataItem
            System.out.println("probabilityInsideDataItemUtil: "+ probability);
            probability*= dist.cumulativeProbability(dataPointOfUnlabelledDataItem);
        }

        System.out.println(probability);
        return probability;

    }
}
