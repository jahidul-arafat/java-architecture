package org.datascience;

import org.apache.commons.math3.distribution.NormalDistribution;

public class Main {
    public static void main(String[] args) {
        Double probability = 1.0;
        System.out.println("Hello world!");
        NormalDistribution dist = new NormalDistribution(10,1);
        System.out.println(probability*dist.cumulativeProbability(200));
    }
}