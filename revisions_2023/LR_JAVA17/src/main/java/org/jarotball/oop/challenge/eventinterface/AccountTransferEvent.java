package org.jarotball.oop.challenge.eventinterface;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountTransferEvent extends AbstractEvent{// Class Attributes
    public AccountTransferEvent(String customerId) {
        super(customerId);
    }

    @Override
    public void process() {
        System.out.format("Customer %s need to transfer their service on or before %s. " +
                "Reaching out to CTE to remove service from old device to the new device%n",
                super.getCustomerId(), super.getTimeStamp());

    }
}
