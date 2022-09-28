package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    // Main method <handleRequest> which receives events as JSON
    /**
     * handleRequests ReturnType-> APIGatewayProxyResponseEvent
     * handleRequests<T, O>
     * handleRequest<receives_an_event_in_json_format, context_of_the_lambda_function>
     * Context:
     * --------
     *  getAwsRequestId();      -> String
     *  getLogGroupName();      -> String
     *  getLogStreamName();     -> String
     *
     *  getFunctionName();      -> String
     *  getFunctionVersion();   -> String
     *  getFunctionVersionArn();-> String
     *  getIdentity();          -> String | Amazon Cognito - handles request authentication; provides solution to control access to AWS resources from your app.
     *
     *  getRemainingTimeInMillis(); -> int
     *  getMemoryLimit();           -> int
     *
     *  getLogger();            -> Logger/Interface
     *
     * */
    @Override
    public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input,
                                                      final Context context) {
        // Create a HashMap <K,V>; This will store the "Content-Type" and "X-Custom-Header" information;
        // These information will be added to the response that will be returned from the Lambda Function
        // Here, content-type = application/json
        // x-custom-header = application/json
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        // define the website URL from where to fetch info
        //var demoURL= "https://bup.edu.bd/";
        var demoURL="https://checkip.amazonaws.com";

        // Create the ProxyResponse (along with the header information we just create above) that gonna be returned to the caller
        // The ProxyResponse includes a GREETING_MSG and server status code: 200/500

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers); // set the header info lambda function will return to caller
        try {
            final String myIP = this.getMyIPAddress(demoURL); // get the ip of my local machine running the lambda function locally
            final String GREETING_MSG="Hello Returned from Lambda";

            //String output = String.format("{\"message\": \"%s\", \"Location(IP)\": \"%s\" }", GREETING_MSG, myIP);
            String output = String.format("message: %s, Location(IP): %s", GREETING_MSG, myIP);

            // return response in json
            // with statusCode:200/successful else 500/internal_server_error(if MicroVM/dockerContainer cant provision)
            //along with the header added to the response
            return response
                    .withStatusCode(200) // if the response is successful;
                    .withBody(output);
        } catch (IOException e) {
            return response
                    .withBody("{}")
                    .withStatusCode(500); // if event invocation failed to create the MicroVM/Docker Container
        }
    }

    // method to get the IP address of my local machine
    public String getMyIPAddress(String address) throws IOException{
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
            return result;
        }
    }
}
