package org.codeclinic.problems.prb2_geolocation.simulation;

import org.codeclinic.utility.AuxiliaryUtils;
import org.codeclinic.utility.GeoDataUtil;
import org.json.JSONObject;

import java.util.Arrays;

public class GeolocationSimulator {
    public static void main(String[] args) {
        String locationInStr="";
        JSONObject outputInJSON = null;

        // Test Case-1: My IP Address, default read even though I didnt provide it manually here
        locationInStr = GeoDataUtil.getGeoData("");
        // convert the string to a json object
        outputInJSON = AuxiliaryUtils.formatStringJSONtoJSON(locationInStr);
        geoReport(outputInJSON.get("country"), outputInJSON.get("city"), outputInJSON.get("loc"));

        // Test Case-2: A well known IP address
        locationInStr = GeoDataUtil.getGeoData("8.8.4.4");
        // convert the string to a json object
        outputInJSON = AuxiliaryUtils.formatStringJSONtoJSON(locationInStr);
        geoReport(outputInJSON.get("country"), outputInJSON.get("city"), outputInJSON.get("loc"));

    }

    public static void geoReport( Object ... objectList){
        String searchURL = "https://www.google.com/maps/?q=";
        System.out.println();
        Arrays.stream(objectList)
                .toList()
                .subList(0, objectList.length-1)
                .stream()
                .map(object -> object.toString())
                .forEach(object -> System.out.format(object+"->"));
        System.out.format(searchURL+Arrays.asList(objectList).get(objectList.length-1));


    }
}
