package com.redbull.movement.metalpart;

import com.redbull.movement.rubberpart.RubberTire;

public class Rim {
    private RubberTire tire;
    private boolean isAntiLockMode;

    public void attach(RubberTire tire) {
        this.tire = tire;
    }

    public void setRpm(double rpm) {
        if (!isAntiLockMode)
            tire.setRpm(rpm);
    }

    // getter and setter
    public void setAntiLockMode(boolean isActivated) {
        this.isAntiLockMode = isActivated;
    }

    public boolean isAntiLockMode() {
        return isAntiLockMode;
    }


}
