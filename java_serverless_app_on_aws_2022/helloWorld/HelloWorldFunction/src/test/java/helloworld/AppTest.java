package helloworld;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.amazonaws.xray.AWSXRay;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

  // Note, the unitTest doesn't know anything of this Segment; So we have to let it know this lambda environment.
  // Otherwise, the maven build will fail as we have just seen.
  // Tests in error:
  //  successfulResponse(helloworld.AppTest): Failed to begin subsegment named '## Calling external service <findHostIP> ...': segment cannot be found.

  @Before
  public void createSegment(){
    AWSXRay.beginSegment("Lambda Segment");
  }
  @Test
  public void successfulResponse() {
    App app = new App();
    APIGatewayProxyResponseEvent result = app.handleRequest(null, null);
    assertEquals(200, result.getStatusCode().intValue());
    assertEquals("application/json", result.getHeaders().get("Content-Type"));
    String content = result.getBody();
    assertNotNull(content);
    //assertTrue(content.contains("\"message\""));
    //assertTrue(content.contains("\"hello world\""));
    //assertTrue(content.contains("\"location\""));
  }
}
