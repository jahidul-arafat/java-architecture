package com.redbull.movement.api;

import com.redbull.movement.metalpart.Rim;
import com.redbull.movement.rubberpart.RubberTire;

public class Wheel {
    private Rim rim;
    private RubberTire tire;

    public static Wheel buildStandardWheel() {
        Wheel wheel = new Wheel();
        RubberTire tire = new RubberTire();
        wheel.attach(new Rim(), tire);

        return wheel;
    }

    public void attach(Rim rim, RubberTire tire) {
        rim.attach(tire);
        this.rim = rim;
        this.tire = tire;
    }

    public void increaseRpm() {
        setRpm(getVelocityInKph() + 1);
    }

    public void decreaseRpm() {
        setRpm(getVelocityInKph() - 1);
    }

    public double getVelocityInKph() {
        double circumferenceInMetres = Math.PI * 2 * tire.getRadiusCm() / 100;
        return tire.getRpm() * 60 * circumferenceInMetres / 1000;
    }

    public double getRpm() {
        return tire.getRpm();
    }

    public RubberTire getRubberTire() {
        return tire;
    }

    private void setRpm(double velocityRequested) {
        double circumferenceInMetres = Math.PI * 2 * tire.getRadiusCm() / 100;
        double rpm = velocityRequested * 1000 / 60.0d / circumferenceInMetres;
        rim.setRpm(rpm);
    }
}
