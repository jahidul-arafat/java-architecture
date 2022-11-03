package org.datascience.datavisualization.scatterplot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.datascience.loadingdata.models.Car.CarRecordUtil;
import org.datascience.loadingdata.utils.FilePath;
import org.datascience.loadingdata.utils.TextLoader;

import java.util.stream.Collectors;

public class ScatterPlotPrb1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 1. Load the data from file <auto-mpg.data> and return each line of that file as a List of String
        var lines = TextLoader.parseLines(FilePath.FILE_PATH +"auto-mpg.data");

        //2. From each line as returned as List<String>, create a car object and return a List of Cars
        var carLists = lines
                .stream()
                .map(line-> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());

        // 3. Preparing Scatter Plot
        // Plot-01: Check the impact of weight on mile-per-galone i.e. speed of a car
        // a. define the axis values
        // a1. xAxis values --> xValues--> weight
//        var xValues = carLists
//                .stream()
//                .map(car -> car.getWeight())
//                .collect(Collectors.toList());

        // a2. yAxis values --> yValues --> mpg
//        var yValues = carLists
//                .stream()
//                .map(car -> car.getMpg())
//                .collect(Collectors.toList());

        // b. define the graph we want to display
        // b1. define xAxis with the xValues::weight
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Weight");

        // b2. define yAxis with yValues::mpg
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("MPG");

        // b3. Create the ScatterChat with these 2x Axis
        ScatterChart<Number,Number> scatterChart = new ScatterChart<>(xAxis,yAxis);

        // b4. Add all the data points in xValues and yValues into the Chart
        // b4i. First, Convert the data points into a Series
        /*
        * Create a Series
        * Iterate through the xValues and yValues and create a XYChart data point with each respective xValues and yValues.
        * Add that respective data point into the series
        * */
        XYChart.Series dataPointSeries = new XYChart.Series();
        carLists
                .forEach(car -> dataPointSeries.getData().add(new XYChart.Data(car.getWeight(), car.getMpg())));

//        for (int i = 0; i <carLists.size() ; i++) {
//            XYChart.Data newDataPoint = new XYChart.Data<>(xValues.get(i), yValues.get(i));
//            dataPointSeries.getData().add(newDataPoint);
//        }

        // b5. Add the dataPointSeries into the ScatterChat object
        scatterChart.getData().add(dataPointSeries);

        // b6. Add a Title to the ScatterChart
        scatterChart.setTitle("Weight Vs. Mileage");

        // b7. Hide all the grid lines: Horizontal, Vertical
        scatterChart.setHorizontalGridLinesVisible(false);
        scatterChart.setVerticalGridLinesVisible(false);

        // c. Show the Scene with the ScatterChat we created above
        // set the scene dimension 900 X 1000
        Scene scene = new Scene(scatterChart,900,1000);

        // add this scene into the primaryStage we passed with the start() method and then let it show
        primaryStage.setScene(scene);
        primaryStage.show();











    }
}
