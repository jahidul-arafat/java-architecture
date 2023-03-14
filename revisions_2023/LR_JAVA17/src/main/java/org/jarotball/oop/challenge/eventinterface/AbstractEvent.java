package org.jarotball.oop.challenge.eventinterface;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractEvent implements Event{
    // Class Attributes
    public SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");

    // Instance Attributes
    private final Long createdTimeStamp;
    private final String customerId;

    public AbstractEvent(String customerId) {
        this.createdTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();
        this.customerId = customerId;
    }

    // getter
    public String getCustomerId() {
        return customerId;
    }

    // Implementing the Interface methods
    @Override
    public String getTimeStamp() {
        return sdf.format(new Date(this.createdTimeStamp));
    }

    @Override
    public abstract void process(); // require implementation
}
