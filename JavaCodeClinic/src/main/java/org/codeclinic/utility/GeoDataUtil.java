package org.codeclinic.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GeoDataUtil {
    public static String getGeoData(String ip){
        // Check if the ip is null, means no manual ip is shared as argument
        // if ip not given, then it will automatically read my current PC ip address
        // if ip is shared, then it willr ead the provided ip, instead the IP of my pc
        // with the IP, it will call https://ipinfo.io to ge the json data
        // if my PC ip, https://ipinfo.io/json returns
        /*
        {
          "ip": "118.179.85.1",
          "city": "Dhaka",
          "region": "Dhaka",
          "country": "BD",
          "loc": "23.7260,90.4251",
          "org": "AS23956 AmberIT Limited",
          "postal": "1217",
          "timezone": "Asia/Dhaka",
          "readme": "https://ipinfo.io/missingauth"
        }
         */

        // return this string
        String responseFromAPI ="";

        // HTML GeoLocation API to be called
        String htmlGeolocationApiURL = "https://ipinfo.io";

        // If IP is provided in argument i.e. 8.8.4.4, then https://ipinfo.io/8.8.4.4/json
        // else, it would be simply https://ipinfo.io/json
        ip = !ip.equals("")?"/"+ip:ip;

        // concatenate the IP with the ApiURL to produce the final URL
        //https://ipinfo.io/8.8.8.8/json        -> if ip shared
        //https://ipinfo.io/json                -> if no ip, read my current PC ip
        String finalHtmlGeolocationApiURL = htmlGeolocationApiURL+ip+"/json";



        // try to establish a connection to the url
        try {
            URL url = new URL(finalHtmlGeolocationApiURL);          // Required: Exception Handling: MalformedURLException
                                                                    // https://ipinfo.io/8.8.8.8/json

            URLConnection connection = url.openConnection();        // Required: Exception Handling: what if failed to establish the connection with the URL requested
                                                                    // sun.net.www.protocol.https.DelegateHttpsURLConnection:https://ipinfo.io/8.8.8.8/json

            // read the JSON contents from the URL
            // requires a buffered reader to read the input stream in json
            // read the stream until reading all the lines from the input stream and convert those into a string and return that string as a result
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line=bufferedReader.readLine())!=null){
                //System.out.println(line);
                responseFromAPI+=line;
            }
            bufferedReader.close();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return responseFromAPI;
    }
}
