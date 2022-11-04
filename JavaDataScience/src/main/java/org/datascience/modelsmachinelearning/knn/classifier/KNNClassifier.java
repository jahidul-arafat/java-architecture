package org.datascience.modelsmachinelearning.knn.classifier;

import javafx.util.Pair;
import org.datascience.loadingdata.utils.HelperUtils;
import org.datascience.modelsmachinelearning.knn.interfaces.DataItem;
import org.datascience.modelsmachinelearning.knn.utils.DataItemUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Make sure this classifier is generic to all of the supervised learning classsification problem.
// Should not be strictly bound only to the FlowerRecords
// For this, create an interface named DataItem

/**
 * The Classifier having a list of DataItems
 */
public class KNNClassifier {
    public List<DataItem> dataItems;

    public KNNClassifier() {
        this.dataItems = new ArrayList<>();
    }

    // customer_methods
    // method_1: add new dataItems into the KNNClassifier
    public void addDataItem(DataItem dItem){
        this.dataItems.add(dItem);
    }

    // method_2: in this method we will pass a new data point and it returns which class it belongs to
    // Return: Map<Species, Votes> -> Map<String, Long> // {Iris-versicolor=4, Iris-setosa=46}
    // Arguments: an unlabelled data point, k:numberOfNeighbours to account into : AnyNumberBetween{1, DataSetSize}
    //[Iris-setosa=4.9779513858614575, Iris-setosa=5.119570294468081, Iris-setosa=5.199038372622383, Iris-setosa=5.231634543811332, Iris-setosa=5.341348144429457, Iris-setosa=5.489990892524322, Iris-setosa=5.522680508593631, Iris-setosa=5.581218504950331, Iris-setosa=5.585696017507577, Iris-setosa=5.588380803059148, Iris-setosa=5.631163290120435, Iris-setosa=5.6471231613982, Iris-setosa=5.668333088307356, Iris-setosa=5.677147170894903, Iris-setosa=5.686826883245172, Iris-setosa=5.742821606144493, Iris-setosa=5.742821606144493, Iris-setosa=5.742821606144493, Iris-setosa=5.794825277780168, Iris-setosa=5.818934610390463, Iris-setosa=5.836094584565949, Iris-setosa=5.905082556577851, Iris-setosa=5.910160742314882, Iris-setosa=5.977457653551382, Iris-setosa=5.992495306631454, Iris-setosa=5.994997914928745, Iris-setosa=6.048140210014976, Iris-setosa=6.052272300549604, Iris-setosa=6.059702963017246, Iris-setosa=6.067948582511227, Iris-setosa=6.091797764207213, Iris-setosa=6.094259594077036, Iris-versicolor=6.102458520956944, Iris-setosa=6.123724356957945, Iris-versicolor=6.146543744251724, Iris-versicolor=6.15223536610881, Iris-versicolor=6.17008914036094, Iris-setosa=6.195159400693416, Iris-setosa=6.220128616033595, Iris-setosa=6.2777384462878025, Iris-setosa=6.299999999999999, Iris-setosa=6.3063460101710245, Iris-setosa=6.350590523722971, Iris-setosa=6.3655321851358195, Iris-setosa=6.385138996137829, Iris-setosa=6.410148204214939, Iris-setosa=6.466838485689897, Iris-setosa=6.5383484153110105, Iris-setosa=6.540642170307133, Iris-setosa=6.613622305514581, Iris-versicolor=6.776429738438966, Iris-versicolor=6.798529252713414, Iris-setosa=6.803675477269621, Iris-setosa=6.812488532100439, Iris-versicolor=6.836665854054885, Iris-virginica=6.903622237637283, Iris-versicolor=6.907966415668218, Iris-setosa=6.912307863514182, Iris-versicolor=6.933253204665181, Iris-versicolor=6.996427659884722, Iris-versicolor=6.999285677838847, Iris-versicolor=7.017121917139534, Iris-setosa=7.102112361825882, Iris-versicolor=7.234638899074369, Iris-versicolor=7.236711960552251, Iris-versicolor=7.247068372797376, Iris-versicolor=7.25120679611332, Iris-versicolor=7.270488291717414, Iris-versicolor=7.303423854604086, Iris-versicolor=7.305477397131552, Iris-versicolor=7.3171032519706865, Iris-versicolor=7.393916418245476, Iris-versicolor=7.401351227985334, Iris-versicolor=7.419568720619818, Iris-versicolor=7.521303078589508, Iris-versicolor=7.545859791965393, Iris-versicolor=7.567033764957046, Iris-versicolor=7.60920495189872, Iris-versicolor=7.749838707999026, Iris-versicolor=7.776245880886227, Iris-virginica=7.792945527847606, Iris-versicolor=7.807048097712733, Iris-virginica=7.829431652425354, Iris-versicolor=7.830070242341381, Iris-virginica=7.880989785553589, Iris-versicolor=7.922120928135344, Iris-versicolor=7.958014827832378, Iris-versicolor=7.978095010715277, Iris-versicolor=7.986864215698175, Iris-virginica=8.00187478032492, Iris-virginica=8.00187478032492, Iris-versicolor=8.00812087820857, Iris-versicolor=8.052949770115296, Iris-virginica=8.053570636680353, Iris-versicolor=8.095677859203638, Iris-versicolor=8.130190649671139, Iris-virginica=8.135109095765095, Iris-virginica=8.14186710773395, Iris-virginica=8.153526844255804, Iris-virginica=8.182909018191513, Iris-versicolor=8.210968274204937, Iris-versicolor=8.218272324521742, Iris-virginica=8.234682750416072, Iris-versicolor=8.240145629781066, Iris-virginica=8.250454532933322, Iris-versicolor=8.296987405076615, Iris-versicolor=8.2975900115636, Iris-virginica=8.333666660000267, Iris-versicolor=8.353442404182841, Iris-virginica=8.417244204607586, Iris-versicolor=8.517041739947034, Iris-versicolor=8.538149682454625, Iris-virginica=8.555115428794634, Iris-versicolor=8.670640114778147, Iris-virginica=8.681589716175258, Iris-virginica=8.692525524840292, Iris-virginica=8.705170877128145, Iris-versicolor=8.773254812211944, Iris-versicolor=8.776103919165953, Iris-virginica=8.778952101475438, Iris-virginica=8.780660567406077, Iris-virginica=8.792041856133308, Iris-virginica=8.799431799837988, Iris-virginica=8.819297024139736, Iris-virginica=8.820430828479978, Iris-virginica=8.889319434017432, Iris-virginica=8.987213138676529, Iris-virginica=9.003332716277901, Iris-virginica=9.016651263079881, Iris-virginica=9.071383576941281, Iris-virginica=9.091754506144564, Iris-virginica=9.140568910084317, Iris-virginica=9.168424073961676, Iris-virginica=9.216832427683602, Iris-virginica=9.231467922275417, Iris-virginica=9.313431161500041, Iris-virginica=9.381364506296512, Iris-virginica=9.426558226627574, Iris-virginica=9.483670175622937, Iris-virginica=9.544108130150246, Iris-virginica=9.68813707582629, Iris-virginica=9.794896630388704, Iris-virginica=9.853425800197614, Iris-virginica=10.000999950005, Iris-virginica=10.141498903022176, Iris-virginica=10.32811696293182, Iris-virginica=10.394229168149028, Iris-virginica=10.520931517693668, Iris-virginica=10.656922632730334, Iris-virginica=10.720074626605918]

    public Map<String, Long> classifyPoint(DataItem unlabelledDataItem, Integer numberOfNeighbors){
        // calculate the distances between unlabelledPoint and all the data points in the KNN Classifier
        List<Pair<String,Double>> pointDistances = this.dataItems
                .stream()
                .map(currentDataItem->
                        new Pair<String, Double>(currentDataItem.getClassifier(),DataItemUtil.getDistance(currentDataItem,unlabelledDataItem)))
                .sorted((dist1, dist2)-> dist1.getValue().compareTo(dist2.getValue())) // ascending // least-to-greatest
                .collect(Collectors.toList());

        //
        //System.out.println(pointDistances); // [Iris-setosa=4.9779513858614575, Iris-setosa=5.119570294468081, Iris-setosa=5.199038372622383 ...]
        //System.out.println("PointDistance Size"+ pointDistances.size());

        var closestLabels = pointDistances
                .subList(0, Math.min(pointDistances.size(),numberOfNeighbors))
                .stream()
                .map(point -> point.getKey())
                .collect(Collectors.toList());

        return HelperUtils.countOccurancesString(closestLabels);

    }
}
