package com.redbull.movement.rubberpart;

public class RubberTire {
    private static final int RADIUS_IN_CM = 83;
    private static final int MAX_RPM_LOW_PRESSURE = 160;
    private static final int LOW_TIRE_KPA = 70;

    private int tirePressureKpa = 205;
    private double rpm;
    private Valve valve = new Valve();

    // constructor
    // class method
//    public static RubberTire buildRubberTire() {
//        RubberTire tire = new RubberTire();
//        Valve valve = new Valve();
//        valve.attachTo(tire);
//
//        return tire;
//    }

    public void setTirePressure(int tirePressureKpa) {
        this.tirePressureKpa = tirePressureKpa;
    }

    public int getTirePressure() {
        return tirePressureKpa;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }

    public double getRpm() {
        return rpm;
    }

    public int getRadiusCm() {
        return RADIUS_IN_CM;
    }
}
