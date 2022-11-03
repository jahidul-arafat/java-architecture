package org.datascience.datavisualization.barchart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.datascience.loadingdata.models.Car.CarRecord;
import org.datascience.loadingdata.utils.FilePath;
import org.datascience.loadingdata.models.Car.CarRecordUtil;
import org.datascience.loadingdata.utils.TextLoader;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Problem-01: How average mileage per gallon (MPG) compares between cars with 4-cylinder engine, 6-cylinder engine and 8-cylinder engine
 */
public class BarGraphPrb1 extends Application {
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

        // 3. Get the 3 different groups of carList based on Cylinder=4,6,8 and calculate the average MPG per group
        //Predicate<CarRecord> cylinderComparator = (car)-> car.getNumberOfCylinders()==4; // for ref // delete it
        Function<Integer, List<CarRecord>> carListByCylinder = (cylinder)->{
            return carLists
                    .stream()
                    .filter(car -> car.getNumberOfCylinders()==cylinder)
                    .collect(Collectors.toList());
        };

        var fourCylinderCars = carListByCylinder.apply(4);
        var sixCylinderCars = carListByCylinder.apply(6);
        var eightCylinderCars = carListByCylinder.apply(8);

        Function<List<CarRecord>, Double> avgMPGCalc = (tmpCarList)-> {
            return tmpCarList
                    .stream()
                    .mapToDouble(car -> car.getMpg())
                    .average()
                    .orElse(-1);
        };

        var avgMPGCalc_4C = avgMPGCalc.apply(fourCylinderCars);
        var avgMPGCalc_6C = avgMPGCalc.apply(sixCylinderCars);
        var avgMPGCalc_8C = avgMPGCalc.apply(eightCylinderCars);

        // 4. BarChart Preparation
        // 4.1 add the cylinder_count and avg_mpg for each group into the series
        XYChart.Series cylAvgSeries = new XYChart.Series<>();
        cylAvgSeries.getData().add(new XYChart.Data("4C", avgMPGCalc_4C));
        cylAvgSeries.getData().add(new XYChart.Data("6C", avgMPGCalc_6C));
        cylAvgSeries.getData().add(new XYChart.Data("8C", avgMPGCalc_8C));
        cylAvgSeries.setName("Avg Mileage Per Cylinder");

        // 4.2 prepare the BarChart
        // a. define the axis
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Cylinder Count");
        yAxis.setLabel("Average MPG");

        // b. define the BarChart
        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);

        // c. add the data series into the barChart
        barChart.getData().add(cylAvgSeries);

        // d. Polish the barChart
        barChart.setTitle("Average MPG of different car engine types");
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
