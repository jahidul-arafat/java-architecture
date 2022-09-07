package com.company.into_generics;

import com.company.models.Building;
import com.company.models.House;
import com.company.models.Office;

import java.util.ArrayList;
import java.util.List;

/**
 * This class at some extent violating the substitution principle
 * Solution 01: is to use wild cards in List<? extends Building>
 * Solution 02: List<? super House>   - means Building is a superclass of House
 * Note: its generally a bad idea to use wildcard as return tyoe for a method
 * */
public class SubstitutionPrinciplesViolationResolved {
    public static void main(String[] args) {
        // Step-0: Create a building
        var building = new Building();
        build(building);

        // Step-1: Create an office
        var office = new Office();
        build(office);

        // Step-2: Create a list of building of type <Building>
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building());
        buildingList.add(new Office());

        addHouseToList(buildingList);                   // will throw compile time error // resolved with ildcard <? super House> means, building is a supertype of house
        printBuildings(buildingList);

        System.out.println();
        // Step-3: Create a list of offices
        List<Office> officeList = new ArrayList<>();  // If List<office> them printBuildings(officeList) will show compile time error.
                                                        // because printBuildings(List<Building>)
                                                        // Substitution principle doesn't apply here
                                                        // Substitution principle lets you assign variables of a given type to the subtype; not subtype to type
        //List<Building> officeList = new ArrayList<>();
        officeList.add(new Office());
        officeList.add(new Office());

        //addHouseToList(officeList);                     // will throw compile time error
        printBuildings(officeList);                     // Compile Time Error - resolved with wildcard

        System.out.println();
        // List of Houses
        List<House> houseList = new ArrayList<>();
        houseList.add(new House());
        houseList.add(new House());
        houseList.add(new House());

        addHouseToList(houseList);
        printBuildings(houseList);



    }

    private static void build(Building building) {
        System.out.println(building);
    }


    // List<? extends Building>
    // ? - wildcard
    // invariable -- use extends
    // here, I am passing a List with provided list which I use inside the method
    public static void printBuildings(List<? extends Building> buildings){
        System.out.println("Into printBuildings() method ...");
        for (Building building:buildings
             ) {
            System.out.println("Constructing a new "+ building);
        }
    }

    // outvariable -- use super
    // here, I am passing a List and it gives additional data by adding into the existing list, means outputting
    // addHouse(buildingList) - resolved
    // means, Building is a superclass of House
    // But, addHouse(officeList) -- would not work

    public static void addHouseToList(List<? super House> buildings) {
        System.out.println("Into addHouseToList() method ...");
        buildings.add(new House());
    }
}
