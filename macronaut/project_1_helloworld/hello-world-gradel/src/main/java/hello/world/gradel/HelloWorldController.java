package hello.world.gradel;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/hello")
public class HelloWorldController {
    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloMicronaut(){
        return "Hello Micronaut - MicroService Development by JA, OCI Project-01";
    }
}