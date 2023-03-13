package org.jarotball.oop.treeexample;

public enum TreeType {
    // enum constants
    OAK("OAK"),
    MAPLE("MAPLE"),
    PECAN("PECAN"),
    WALNUT("WALNUT"),
    PINE("PINE");

    //
    private final String desc;

    // enum constructor
    TreeType(String desc) {
        this.desc = desc;
    }

    // Getter
    // No Setter
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
