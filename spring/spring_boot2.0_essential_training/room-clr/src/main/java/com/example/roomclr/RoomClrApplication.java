package com.example.roomclr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RoomClrApplication {
    // We are not going to use the default logging of java, instead using Slf4j api
    // Create a Logger for clean logging of your application
    // using LoggerFactory and logger from Slf4j logging facade
    // Logging at the runtime require the respective class in the Target/
    // This Logger should be a Class Attribute and final
    private static final Logger LOG = LoggerFactory.getLogger(RoomClrApplication.class);

    // Define 2x beans;
    // All @Service, @Entity, @Controller etc are the beans which are automatically wired to the Applicaiton Context (wrapper) at the runtime
    // The ApplicationContext has a BeanFactroy which serves the Beans at the runtime
    // We dont directly interact with the BeanFactory, instead interact with the ApplicationContext wrapper
    // Like the @Service, @Entity etc, these beans could be a separate class, but for simplicity we let it remains in a single class with @Bean annotation

    // Bean-01 A RestTemplate
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }


    // Bean-02: A CommandLineRunner on which we will pass the RestTemplate
    //

    @Bean
    public CommandLineRunner commandLineRunner(RestTemplate restTemplate){
        return args -> {
            LOG.info("Starting CLR application");
            ResponseEntity<List<Room>> roomList = restTemplate.exchange("http://localhost:8080/api/room",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
                    });
            roomList.getBody()
                    .forEach(room -> {
                        LOG.info(room.toString());
                    });
            LOG.info("Finishing CLR application");
        };
    }



    public static void main(String[] args) {
        SpringApplication.run(RoomClrApplication.class, args);
    }

}
