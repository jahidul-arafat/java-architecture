package org.datascience.loadingdata.models.Grocery;

import java.util.Date;

public class GroceryRecord {
    private final String memberNumber;
    //private final Date dateOfPurchase;
    private final String dateOfPurchase;
    private final String itemDescription;

    // constructor
    public GroceryRecord(String memberNumber, String dateOfJoining, String itemDescription) {
        this.memberNumber = memberNumber;
        this.dateOfPurchase = dateOfJoining;
        this.itemDescription = itemDescription;
    }

    // getter
    public String getMemberNumber() {
        return memberNumber;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    // Print the Object
    @Override
    public String toString() {
        return "Grocery{" +
                "memberNumber=" + memberNumber +
                ", dateOfJoining=" + dateOfPurchase +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }
}
