package org.jarotball.oop.challenge.eventinterface;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MissedPaymentEvent extends AbstractEvent{
    public MissedPaymentEvent(String customerId) {
        super(customerId);
    }

    // Implementing the Interface methods
    @Override
    public void process() {
        System.out.format("Customer %s missed their payment on or before %s. " +
                "Sending a bill to the customer%n", super.getCustomerId(), super.getTimeStamp());

    }
}
