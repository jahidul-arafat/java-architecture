package org.datascience.datavisualization.scatterplot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.datascience.loadingdata.models.Car.CarRecord;
import org.datascience.loadingdata.models.Car.CarRecordUtil;
import org.datascience.loadingdata.utils.TextLoader;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ScatterPlotPrb2 extends Application {
    static String filePath= "/Users/jarotball/Study/java_architect/JavaDataScience/src/main/java/org/datascience/loadingdata/sampledata/";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 1. Reading Car Attributes from data File
        // Load the data from file <auto-mpg.data> and return each line of that file as a List of String
        var lines = TextLoader.parseLines(filePath+"auto-mpg.data");

        // 2. Creating Car Objects
        // Create Car Objects from the List<String> returned from file
        var carLists = lines
                .stream()
                .map(line-> CarRecordUtil.parseCar(line))
                .collect(Collectors.toList());
        //carLists.forEach(System.out::println);

        // 3. Data Preparation
        // Create two subGroups of cars made on or before 1976 and the one after 1976
        BiFunction<Integer, String, List<CarRecord>> carByYear = (year, comparator)-> {
            if (comparator.equalsIgnoreCase("gt"))
                return carLists
                        .stream()
                        .filter(car -> car.getYear() > year)
                        .collect(Collectors.toList());
            return carLists
                  .stream()
                  .filter(car-> car.getYear()<=year)
                  .collect(Collectors.toList());
        };

        var olderCarList = carByYear.apply(76, "lte");
        var newerCarList = carByYear.apply(76,"gt");

        // 4. ScatterPlot Preparation
        // 4.1 Prepare the Data Point Series for both Older Cars and Newer Cars
        // Put the olderCar (weight, mpg) in one dataPointSeries
        XYChart.Series olderCarDataPointSeries = new XYChart.Series();
        olderCarList
                .forEach(car-> olderCarDataPointSeries.getData().add(new XYChart.Data(car.getWeight(), car.getMpg())));
        olderCarDataPointSeries.setName("Cars on or before 1976");

        // put the newerCar (weight, mpg) in another dataPointSeries
        XYChart.Series newerCarDataPointSeries = new XYChart.Series();
        newerCarList
                .forEach(car -> newerCarDataPointSeries.getData().add(new XYChart.Data(car.getWeight(), car.getMpg())));
        newerCarDataPointSeries.setName("Cars After 1976");

        // 4.2 Prepare the xAxis and yAxis and label them
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Weight");
        yAxis.setLabel("Mileage");

        // 4.3 Prepare the ScatterChart with the axises defined and add the olderCarSeries data and newerCarSeries data into it
        ScatterChart <Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        scatterChart.getData().add(olderCarDataPointSeries);
        scatterChart.getData().add(newerCarDataPointSeries);

        // 4.4 Polishing the Scatter Chart
        scatterChart.setTitle("Weight Vs Mileage :: By Year");
        scatterChart.setHorizontalGridLinesVisible(false);
        scatterChart.setVerticalGridLinesVisible(false);

        // 4.5 Add the ScatterChart into the Scene anf finally add the Scene into primaryStage
        Scene scene = new Scene(scatterChart, 900,1000);
        primaryStage.setScene(scene);
        primaryStage.show();














        












    }
}
