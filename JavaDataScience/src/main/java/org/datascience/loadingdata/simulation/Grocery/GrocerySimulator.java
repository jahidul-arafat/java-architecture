package org.datascience.loadingdata.simulation.Grocery;

import org.apache.commons.csv.CSVRecord;
import org.datascience.loadingdata.models.Grocery.GroceryRecord;
import org.datascience.loadingdata.models.Grocery.GroceryRecordUtil;
import org.datascience.loadingdata.utils.CSVLoader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GrocerySimulator {
    static String filePath= "/Users/jarotball/Study/java_architect/JavaDataScience/src/main/java/org/datascience/loadingdata/sampledata/";

    public static void main(String[] args) {
        List<CSVRecord> csvRecordList= CSVLoader.parseCSV(filePath+"Groceries_dataset.csv");
        var groceryRecordList = csvRecordList
                .stream()
                .map((record)-> GroceryRecordUtil.parseGroceryItem(record))
                .collect(Collectors.toList());

//        groceryRecordList
//                .forEach(System.out::println);

        /**
         * Scenarios:
         * 1. How many total unique members at this Grocery shop, made a purchase
         * 2. How many total items purchased by each customer
         * 3. Total items purchased by all customers
         * 4. Average number of items purchased by all customer
         * 5. Maximum Number of items ever purchased by a customer
         * 6. Minimum number of items ever purchased by a customer
         * 6. Find the customer's member numbers made the maximum purchased
         * 7. Find the customer's member numbers made the minimum purchases
         * 8. Find the customers whose total purchase is below average
         * 9. Find the customers whole total purchase is above average
         * 10. Find the items purchased by a specific customer
         * 11. Find total purchases on a specific day
         * 12. Find the customers who has purchased on a specific day
         */

        // 1. How many total unique members at this Grocery shop, made a purchase
        var totalUniqueMember = groceryRecordList
                .stream()
                .map(purchaseRecord -> purchaseRecord.getMemberNumber())
                .collect(Collectors.toSet());
        System.out.println("Total Unique Members: "+ totalUniqueMember.size());

        // 2. How many total items purchased by each customer and sort the customer based on their total item purchased
        var itemPurchasedPerMember = groceryRecordList
                .stream()
                .collect(Collectors.groupingBy(GroceryRecord::getMemberNumber))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .collect(Collectors.counting())
                ))
                .entrySet()
                .stream()
                .sorted((mem1,mem2)-> mem2.getValue().compareTo(mem1.getValue()))
                .collect(Collectors.toMap(
                        (entry) -> entry.getKey(),
                        (entry)-> entry.getValue(),
                        (e1,e2)->e1,
                        LinkedHashMap::new
                ));
        //var x = GroceryRecordUtil.sortByValue(itemPurchasedPerMember);
        System.out.println("Items Purchased Per Member: "+ itemPurchasedPerMember);

        // 2.1 Search Technique for itemPurchasedPerMember
        Function<String,Long> searchItemPurchasedPerMember = (memberNumber)-> itemPurchasedPerMember.get(memberNumber);
        System.out.println("Search Item purchased by member: "+searchItemPurchasedPerMember.apply("3050"));

        // 3. Total items purchased by all Members
        var totalItemPurchasedByAllMembers = groceryRecordList
                .stream()
                .filter(groceryRecord -> groceryRecord.getItemDescription()!=null)
                .collect(Collectors.counting());
        System.out.println("Total Items purchased by all members: "+ totalItemPurchasedByAllMembers);

        // 4. Average number of items purchased by all member
        double avgNumOfItemsPurchased = Math.round((double)totalItemPurchasedByAllMembers/totalUniqueMember.size());
        System.out.format("On Average %s items purchased by %s members%n", avgNumOfItemsPurchased, totalUniqueMember.size());

        // 5. Maximum and Minimum Number of items ever purchased by a customer
        var maxItems = itemPurchasedPerMember
                .entrySet()
                .stream()
                .max((mem1,mem2)-> mem1.getValue().compareTo(mem2.getValue()))
                .get();
        System.out.format("Max %s items Purchased by Member %s%n", maxItems.getValue(), maxItems.getKey());

        var minItems = itemPurchasedPerMember
                .entrySet()
                .stream()
                .min((mem1,mem2)-> mem1.getValue().compareTo(mem2.getValue()))
                .get();
        System.out.format("Min %s items Purchased by Member %s%n", minItems.getValue(), minItems.getKey());

        // 6. grouping members by the itemPurchaseCount
        BiFunction<Long,LinkedHashMap<String,Long>,String> xFunc = (itemCount, tempItemPurchasedPerMember)-> {
            var keyOftheValue=tempItemPurchasedPerMember
                    .entrySet()
                    .stream()
                    .filter(entry -> itemCount.equals(entry.getValue()))
                    .map(entry -> entry.getKey())
                    .collect(Collectors.toList())
                    .stream().findFirst()
                    .orElse(null);
            return keyOftheValue;
        };

        // get unique set of all itemPurchaseCount made by Members
        var itemCountList = itemPurchasedPerMember.values().stream().collect(Collectors.toList());

        Map<Long,List<String>> swapItemPurchasePerMember = new HashMap<>();
        LinkedHashMap<String,Long> copyItemPurchasedPerMember = new LinkedHashMap<>();
        copyItemPurchasedPerMember.putAll(itemPurchasedPerMember);

        for (Long itemCount: itemCountList
             ) {
            if (!swapItemPurchasePerMember.keySet().contains(itemCount))
                swapItemPurchasePerMember.put(itemCount,new ArrayList<>());
            var theKey = xFunc.apply(itemCount,copyItemPurchasedPerMember);
            swapItemPurchasePerMember.get(itemCount).add(theKey);
            copyItemPurchasedPerMember.remove(theKey);
        }

        System.out.println("swapItemPurchasePerMember: "+swapItemPurchasePerMember);
        //System.out.println("copy: "+ copyItemPurchasedPerMember);
        //System.out.println("original:" + itemPurchasedPerMember);

        // Output Expected: {2=248, 3=54, 4=328, 5=178, 6=371}
        var itemCountMemberCount = swapItemPurchasePerMember
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        (entry)-> entry.getKey(),
                        (entry)-> entry.getValue()
                                .stream()
                                .collect(Collectors.counting())
                ));
        System.out.println("Item Count Member Count: "+ itemCountMemberCount);

        // total members
        var totalMembersRetrieved = itemCountMemberCount
                .values()
                .stream()
                .reduce(0l, (acc,x)-> acc+x);
        System.out.println("Total Members Retrieved: "+ totalMembersRetrieved);

        // how many customers purchased the minimum number of items i.e. 2 and who are those customers
        System.out.println(minItems.getValue()+ " " + itemCountMemberCount.get(minItems.getValue())+ " "+ swapItemPurchasePerMember.get(minItems.getValue()));

        // // how many Members purchased the maximum number of items and who are those customers
        System.out.println(maxItems.getValue()+ " " + itemCountMemberCount.get(maxItems.getValue())+ " "+ swapItemPurchasePerMember.get(maxItems.getValue()));


        // 8. Find the customers whose total purchase is below average

        // 9. Find the customers whole total purchase is above average
        // 10. Find the items purchased by a specific customer
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println();
        var itemsPurchasedByMembers = groceryRecordList
                .stream()
                .collect(Collectors.groupingBy(GroceryRecord::getMemberNumber));

        Function<String, Void> itemListByMember = (memberNumber)->{
            itemsPurchasedByMembers
                    .get(memberNumber)
                    .stream()
                    .forEach((item)-> {
                        try {
                            System.out.format("Item (%s), purchased on (%s) by Member (%s)%n",
                                    item.getItemDescription(),
                                    simpleDateFormat.parse(item.getDateOfPurchase()),
                                    item.getMemberNumber());
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    });
            return null;

        };

        itemListByMember.apply("2304");
        System.out.println();
        itemListByMember.apply("3640");


        // 11. Find total purchases on a specific day
        System.out.println();
        var itemPurchasedByDate = groceryRecordList
                .stream()
                .collect(Collectors.groupingBy(GroceryRecord::getDateOfPurchase));

        System.out.println("Purchasing Dates: "+ itemPurchasedByDate.keySet());

        Function<String, Void> purchasedOnDateFunc = (onDate)-> {
            itemPurchasedByDate.get(onDate)
                    .stream()
                    .forEach(item -> System.out.println(item.getItemDescription()+ " " + item.getMemberNumber()));
            return null;

        };

        // how many days of purchase
        System.out.println("Days of Purchase: "+ itemPurchasedByDate.keySet().size());

        // purchase made on a specific date
        purchasedOnDateFunc.apply("16-02-2015");
        System.out.println();

        //purchasedOnDateFunc.apply("05-01-2015");


        // 12. Find whether a customer made purchase on a specific day
        BiFunction<String,String,List<String>> hasCustomerPurchasedOnDate = (memberNumber, dateOfPurchase)-> {
            if (!itemPurchasedByDate.keySet().contains(dateOfPurchase))
                return new ArrayList<>();
            return itemPurchasedByDate
                    .get(dateOfPurchase)
                    .stream()
                    .filter(item -> item.getMemberNumber().equals(memberNumber))
                    .map(item-> item.getItemDescription())
                    .collect(Collectors.toList());
        };

        System.out.println(hasCustomerPurchasedOnDate.apply("3891","16-02-2015"));


    }
}
