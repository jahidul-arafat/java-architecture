package helloworld;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


@Slf4j
public class FindHostIP {
    public static String findLambdaHostServerIPAddress(String address) throws IOException {
        log.debug("Into the fingMyIPAddress method... trying to fetch the host machine IP");
        // Instantiate the URL class
        URL url = new URL(address);

        // Retrieve the contents of the specified page
        try(Scanner sc = new Scanner(url.openStream())){
            // Instantiate the StringBuffer class to hold the result
            StringBuffer sb = new StringBuffer();

            // read the first 100 string of the website URL as mentioned in <address>
            // or just read the IP address from the site
            //var lineCounter=1;
            while (sc.hasNext()){
                sb.append(sc.next());
            }

            // Retrieving the String from String Buffer Object
            var result = sb.toString();

            // remove the HTML tags
            result=result.replaceAll("<[^>]*>","");
            log.info("Returning the result from function");
            return result;
        }
    }
}
