package org.datascience.datavisualization.barchart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.datascience.loadingdata.models.Car.CarRecord;
import org.datascience.loadingdata.models.Car.CarRecordUtil;
import org.datascience.loadingdata.utils.FilePath;
import org.datascience.loadingdata.utils.TextLoader;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BarGraphChallenge1 extends Application {

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

        // 3. Get 3 different CarList by Car origin
        // Group the cars by their origin
        Function<Integer, List<CarRecord>> carsListByOrigin = (tmpOrigin)->{
            return carLists
                    .stream()
                    .filter(car -> car.getOrigin()==tmpOrigin)
                    .collect(Collectors.toList());
        };

        var oneOriginCars = carsListByOrigin.apply(1);
        var twoOriginCars = carsListByOrigin.apply(2);
        var threeOriginCars = carsListByOrigin.apply(3);

        // calculate the average MPG per origin
        Function<List<CarRecord>, Double> avgMPGByOrigin = (tmpCarList)->{
            return tmpCarList
                    .stream()
                    .mapToDouble(CarRecord::getMpg)
                    .average()
                    .orElse(-1);
        };

        var avrMPGByOrigin1= avgMPGByOrigin.apply(oneOriginCars);
        var avrMPGByOrigin2= avgMPGByOrigin.apply(twoOriginCars);
        var avrMPGByOrigin3= avgMPGByOrigin.apply(threeOriginCars);

        // 4. BarChart Preparation
        // 4.1 add the origin and avg_mpg for each group into the series
        XYChart.Series originAvgSeries = new XYChart.Series<>();
        originAvgSeries.getData().add(new XYChart.Data("1:America", avrMPGByOrigin1));
        originAvgSeries.getData().add(new XYChart.Data("2:Europe", avrMPGByOrigin2));
        originAvgSeries.getData().add(new XYChart.Data("3:Asia", avrMPGByOrigin3));
        originAvgSeries.setName("Avg Mileage Per Origin");

        // 4.2 prepare the BarChart
        // a. define the axis
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Origin");
        yAxis.setLabel("Average MPG");

        // b. define the BarChart
        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);

        // c. add the data series into the barChart
        barChart.getData().add(originAvgSeries);

        // d. Polish the barChart
        barChart.setTitle("Average MPG of different car Origin");
        barChart.setHorizontalGridLinesVisible(false);
        barChart.setVerticalGridLinesVisible(false);
        barChart.setAnimated(false);


        // e. Create a Scene with resolution, add the BarChart into the Scene and
        // finally add the Scene into primaryStage and then show the primaryStage
        Scene scene = new Scene(barChart, 700,1700);
        primaryStage.setScene(scene);
        primaryStage.show();




    }
}
