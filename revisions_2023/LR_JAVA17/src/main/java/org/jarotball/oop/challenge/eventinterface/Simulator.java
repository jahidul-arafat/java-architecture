package org.jarotball.oop.challenge.eventinterface;

import java.util.Arrays;
import java.util.List;

public class Simulator {
    public static void main(String[] args) {
        PasswordChangeEvent event1 = new PasswordChangeEvent("101");
        MissedPaymentEvent event2 = new MissedPaymentEvent("102");
        AccountTransferEvent event3 = new AccountTransferEvent("103");

        Event[] events = {event1,event2,event3};
        Arrays.stream(events)
                        .forEach(event -> event.process());

    }
}
