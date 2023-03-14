package org.jarotball.oop.challenge.eventinterface;

public interface Event {
    // Methods to be implemented by the Classes implementing this interface
    // Note: Interface can't define attributes
    String getTimeStamp();
    void process();
}
