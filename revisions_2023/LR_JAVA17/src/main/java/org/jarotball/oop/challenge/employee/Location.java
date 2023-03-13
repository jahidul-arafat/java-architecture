package org.jarotball.oop.challenge.employee;

public enum Location {
    // enum constants
    DHK("Dhaka"),
    CML("Cumilla"),
    CTG("Chittagong"),
    SYL("Sylhet"),
    KHU("Khulna");

    private final String city;

    Location(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.city;
    }
}
