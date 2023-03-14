package org.jarotball.oop.challenge.eventinterface;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PasswordChangeEvent extends AbstractEvent {
    // Constructor
    public PasswordChangeEvent(String customerId) {
        super(customerId);
    }

    @Override
    public void process() {
        System.out.format("Customer %s changed their password at %s. " +
                "Sending a confirmation email to customer.%n",
                super.getCustomerId(), super.getTimeStamp());
    }
}
