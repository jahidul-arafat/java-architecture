package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Handler for requests to Lambda function.
 * (a) Added a logger from the logger factory
 *      - To make things easier, I am using Lombok annotations @Slf4j
 * (b) Now, add a couple of log files inside handler, the main method that going to be executed upon invocation
 *
 */

@Slf4j
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    // Add global variables (if-any) below
    // i.e. Database connection


    // Add init code below



    // this is the main method <handlerRequest> aka handler;
    // this invoked upon client hitting the endpoint requesting the lambda function
    // handleRequest(T, O) is the method from interface: RequestHandler and thus implemented here with @Override annotation
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
        /**
         * Create a HashMap <K,V>; This will store the "Content-Type" and "X-Custom-Header" information;
         * These information will be added to the response that will be returned from the Lambda Function
         * Here, content-type = application/json
         * x-custom-header = application/json
         * */

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        // Add some random log files here
        // Trace and Debug message are not logged
        log.trace("This is TRACE message");
        log.debug("This is DEBUG message");
        log.info("This is INFO message");
        log.warn("This is WARN message");
        log.error("This is ERROR message");


        // ------- BEGIN: This section is for testing, don't include this in Primary version of this function----
        // i.e. this code if for function V2, where I am trying to make some slight changes and later will upload the updated function in AWS Lambda
        // to upload this new version of Lambda function in the existing AWS Lambda codebase
        // Step-01: Package this using maven > maven package ; which eventually creates a JAR file
        // Step-02: Upload the JAR file using AWS lambda Function>Code console
        // Step-03: Test the code with an empty JSON event file {} and in the response section check the message written below is appearing

        System.out.println("Updated to Lambda Function Code v 3. Earlier was: v2");

        // ----------------------- ENDS -------------------

        // define the website URL from where to fetch info
        //var demoURL= "https://bup.edu.bd/";
        var demoURL="https://checkip.amazonaws.com";

        // Create the ProxyResponse (along with the header information we just create above) that gonna be returned to the caller
        // The ProxyResponse includes a GREETING_MSG and server status code: 200/500 along with the header info we set above

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers); // set the header info lambda function will return to caller
        try {
            log.info("Before calling checkip");
            final String lambdaHostServerIP = FindHostIP.findLambdaHostServerIPAddress(demoURL); // get the ip of my local machine running the lambda function locally
            final String GREETING_MSG="Thanks for visiting this serverless Application/Lambda developed using JAVA, designed in AWS  \n" +
                    "Designed by Jahidul Arafat, Sr. Architect, Oracle, JAPAC\n" +
                    "Visit: https://www.linkedin.com/in/jahidul-arafat-791a7490/";
            log.info("After calling checkip");

            //String output = String.format("{\"message\": \"%s\", \"Location(IP)\": \"%s\" }", GREETING_MSG, lambdaHostServerIP);
            String output = String.format("message: %s, Location(IP): %s", GREETING_MSG, lambdaHostServerIP);

            // return response in json
            // with statusCode:200/successful else 500/internal_server_error(if MicroVM/dockerContainer cant provision)
            //along with the header added to the response
            return response
                    .withStatusCode(200) // if the response is successful;
                    .withBody(output);
        } catch (IOException e) {
            log.error("error while calling checkip",e);
            return response
                    .withBody("{}")
                    .withStatusCode(500); // if event invocation failed to create the MicroVM/Docker Container
        }
    }
}
