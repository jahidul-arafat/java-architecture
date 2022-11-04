package org.datascience.modelsmachinelearning.knn.problem1_flower;

import org.datascience.loadingdata.models.Iris.FlowerRecord;
import org.datascience.loadingdata.models.Iris.FlowerRecordUtil;
import org.datascience.loadingdata.utils.FilePath;
import org.datascience.loadingdata.utils.TextLoader;
import org.datascience.modelsmachinelearning.knn.classifier.KNNClassifier;

import java.util.stream.Collectors;

public class KNNSimulatorFlower {
    public static void main(String[] args) {
        // 1. Load the data from file <auto-mpg.data> and return each line of that file as a List of String
        var lines = TextLoader.parseLines(FilePath.FILE_PATH +"iris.data");

        //2. From each line as returned as List<String>, create a flower object and return a List of Flowers
        var flowerLists = lines
                .stream()
                .map(line-> FlowerRecordUtil.parseFlower(line))
                .collect(Collectors.toList());

        flowerLists.forEach(System.out::println); // check is there any extra line at the end in your dataset. If so, flowerObject will return null.

        // 3. Call the KNN Classifier
        KNNClassifier knnClassifier = new KNNClassifier();

        // 3.1 Add the flowerRecords as KNNClassifier DataItems
        flowerLists.forEach((flower)-> knnClassifier.addDataItem(flower));

        // 3.2 Get the Distances of the newDataItem from all the dataItems in the KNNClassifier, sort them is ascending order
        // {Iris-versicolor=4, Iris-setosa=46}
        var x=knnClassifier.classifyPoint(
                new FlowerRecord(0.0,0.0,2.5,0.75,"?"),
                30);
        System.out.println(x);


    }

}
