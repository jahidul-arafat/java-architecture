package org.datascience.modelsmachinelearning.naivebayes.problem1_flower;

import org.datascience.loadingdata.models.Iris.FlowerRecord;
import org.datascience.loadingdata.models.Iris.FlowerRecordUtil;
import org.datascience.loadingdata.utils.FilePath;
import org.datascience.loadingdata.utils.TextLoader;
import org.datascience.modelsmachinelearning.naivebayes.classifier.NaiveBayesClassifier;

import java.util.stream.Collectors;

public class NBSimulatorFlower {
    public static void main(String[] args) {
        // 1. Load the data from file <auto-mpg.data> and return each line of that file as a List of String
        var lines = TextLoader.parseLines(FilePath.FILE_PATH +"iris.data");

        //2. From each line as returned as List<String>, create a flower object and return a List of Flowers
        var flowerLists = lines
                .stream()
                .map(line-> FlowerRecordUtil.parseFlower(line))
                .collect(Collectors.toList());

        flowerLists.forEach(System.out::println); // check is there any extra line at the end in your dataset. If so, flowerObject will return null.

        // 3. NaiveBayse Algorithm
        // 3.1 Add the FlowerRecords into the NaiveBayes Classifier
        NaiveBayesClassifier naiveBayesClassifier = new NaiveBayesClassifier();
        flowerLists
                .forEach(flowerRecord -> naiveBayesClassifier.addDataItem(flowerRecord));

        // 3.2 Calculate the Probability of a new FlowerRecord belongs to which Group
        // Currently there are three groups: <iris-setosa>, <iris-versicolour> and <iris-virginica>
        var finalLabelAndProb= naiveBayesClassifier.classifyPoint(
                new FlowerRecord(6.2,2.2,4.5,1.5,"?"));
        System.out.println(finalLabelAndProb); // in NB classifier, probability will not add up to 1
        // {Iris-versicolor=2.5652689306634284E-9, Iris-virginica=3.5805525458223586E-30, Iris-setosa=0.0}
    }
}
