package org.datascience.modelsmachinelearning.naivebayes.classifier;

import org.datascience.modelsmachinelearning.knn.interfaces.DataItem;
import org.datascience.modelsmachinelearning.knn.utils.DataItemUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.datascience.modelsmachinelearning.knn.utils.DataItemUtil.*;


// Objective: Give dataPoint, predict the label
// Statistics applied

/**
 * Naive Bayes assumes that all features are independent or unrelated, so it cannot learn the relationship between features.
 * Applications
 * -----------
 * It is used for Credit Scoring.
 * It is used in medical data classification.
 * It can be used in real-time predictions because Naïve Bayes Classifier is an eager learner.
 * It is used in Text classification such as Spam filtering and Sentiment analysis.
 *
 *
 * Note: Naive Bayes classifier gives a probability greater than 1.

 */
public class NaiveBayesClassifier {
    // Instance Attributes
    /*
    *   A List of Data Items - where we will add each flower Objects
    *   Flower Object implemented the interface <flower>
     */
    List<DataItem> dataItems;

    // Constructor
    public NaiveBayesClassifier() {
        this.dataItems = new ArrayList<>();
    }

    // Custom_methods
    // custom_method_1: add a new dataItem into the dataItem list
    // Note dataItem of type<DataItem:: Interface>
    // DataItem interface having 2x methods : getCoordinates--> dataPoint and getClassifier--> label
    public void addDataItem(DataItem dItem){
        this.dataItems.add(dItem);
    }

    // custom_method_2: classify a given datapoint and predict its label
    // method attribute: 1x, unlabelledDataItem of type<DataItem::FlowerRecord>
    // Output Expected: label::probability Map<String, Double>

    public Map<String, Double> classifyPoint(DataItem unlabelledDataItem){
        // get the unique set of labels from all the dataItems in the existing dataset
        var allLabelsFromExistingDataSet = this.dataItems
                .stream()
                .map(dItem -> dItem.getClassifier())
                .collect(Collectors.toSet())
                .stream().toList();

        // Create the Map where to store the groupLabel and the statistics that the group produced
        // this Map will be returned at the end
        Map<String, Double> probabilityByGroupLabel = new HashMap<>();

        // group the data items based on their label
        // and for each label, for each colume in the dataset, calculate the mean and SD
        var groupedDataItems= this.dataItems
                .stream()
                .collect(Collectors.groupingBy(DataItem::getClassifier));

        System.out.println(groupedDataItems);

        for (String groupLabel: groupedDataItems.keySet()
             ) {
            System.out.println(groupLabel);
            // get the dataItem list of the respective groupLabel
            // 4 attributes in each list item: <sepalLength, sepalWidth, petalLength, petalWidth>
            // can be retrieved by dItem.getCoordinates() method implemented by class <FlowerRecord>
            var dataItemListOfTheGroup= groupedDataItems.get(groupLabel);
            System.out.println(dataItemListOfTheGroup);

            // for each dataItemList of the respective group
            // calculate mean and SD
            // 2x external Methods will be called from DataItemUtils: getDataItemsMean, getDataItemsSD :: return List<Double> for each 4 columns
            List<Double> groupDataColumnMeans= getColumnMeans(dataItemListOfTheGroup);  // TBD
            List<Double> groupDataColumnSDs = getColumnSDs(dataItemListOfTheGroup);    //  TBD

            // Map :: <Label::String, Probability::Double>
            probabilityByGroupLabel.put(
                    groupLabel,
                    getLabelProbabilityForNewDataPoint(             //  TBD
                            groupDataColumnMeans,
                            groupDataColumnSDs,
                            unlabelledDataItem)
            );
        }

        return probabilityByGroupLabel;

    }


}
