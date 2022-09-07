package com.company.into_generics;

import com.company.models.Building;
import com.company.models.Office;

import java.util.ArrayList;
import java.util.List;

/**
 * This class at some extent violating the substitution principle
 * Solution: is to use wild cards in List<?: extends SuperClass>
 * */
public class SubstitutionPrinciplesViolation {
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
        printBuildings(buildingList);

        System.out.println();
        // Step-3: Create a list of offices
        //List<Office> officeList = new ArrayList<>();  // If List<office> them printBuildings(officeList) will show compile time error.
                                                        // because printBuildings(List<Building>)
                                                        // Substitution principle doesn't apply here
                                                        // Substitution principle lets you assign variables of a given type to the subtype; not subtype to type
        List<Building> officeList = new ArrayList<>();
        officeList.add(new Office());
        officeList.add(new Office());
        printBuildings(officeList);                     // Compile Time Error

    }

    private static void build(Building building) {
        System.out.println(building);
    }


    public static void printBuildings(List<Building> buildings){
        for (Building building:buildings
             ) {
            System.out.println("Constructing a new "+ building);
        }
    }
}
