package com.example.fizzbuzz.clr;

import com.example.fizzbuzz.FizzbuzzApplication;
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
public class FizzBuzzClrApplication {
    private static final Logger LOG = LoggerFactory.getLogger(FizzbuzzApplication.class);

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
            LOG.info("Starting FizzBuzz CLR application");
            ResponseEntity<List> numFizzBuzzList = restTemplate.exchange("http://localhost:8181/api/fizzbuzz",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List>() {
                    });
            numFizzBuzzList.getBody()
                    .forEach(room -> {
                        LOG.info(room.toString());
                    });
            LOG.info("Finishing FizzBuzz CLR application");
        };
    }
}
