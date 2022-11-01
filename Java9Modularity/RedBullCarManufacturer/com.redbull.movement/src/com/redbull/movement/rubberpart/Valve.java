package com.redbull.movement.rubberpart;
// the valve is Packaged private; means accessible only from same class and same package;
// Valve must not be exposed to foreign modules

class Valve {
    private RubberTire tire;

    public RubberTire getTire() {
        return tire;
    }

    public void setTire(RubberTire tire) {
        this.tire = tire;
    }

    public void pumpAir() {
        tire.setTirePressure(285);
    }

}
