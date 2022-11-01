package com.redbull.movement.api;

public class TestWheel {
    public static void main(String[] args) {
        Wheel wheel = Wheel.buildStandardWheel();

        while (wheel.getVelocityInKph()<100){
            System.out.format("Increasing speed ...%s --> %s%n", (int)wheel.getVelocityInKph(), (int)wheel.getRpm());
            wheel.increaseRpm();
        }

        while (wheel.getVelocityInKph()>0){
            System.out.format("Decreasing speed ...%s --> %s%n", (int)wheel.getVelocityInKph(), (int)wheel.getRpm());
            wheel.decreaseRpm();
        }
    }
}
