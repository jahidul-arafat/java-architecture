package com.example.bootingweb.models;

public enum Position {
    HOUSEKEEPING("Housekeeping"),
    FRONT_DESK("Front Desk"),
    SECURITY("Security"),
    CONCIERGE("Concierge");

    private final String position;

    Position(String position) {
        this.position=position;
    }

    @Override
    public String toString() {
        return position;
    }
}
