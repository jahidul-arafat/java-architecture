package com.jarotball.firstclass_functions.function_as_data.loading_from_server;

public class Simulator {
    public static void main(String[] args) {
        // Define the Environment
        final boolean IS_DEVELOPMENT = false;

        // Let's load the data;
        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);
        System.out.println(dataLoader.loadData.apply());



    }
}
