package com.example.roomcleanernotifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;


    // We all know ApplicaitonContext act as a wrapper on the top of BeanFactory:: the core container to serve beans at the application runtime
    // But That doesnt maintain the entire lefecycle of the Beans
    // If you want to maintain the entire lifecycles of the Beans you require 'ConfigurableApplicationContext' which is an extension of 'ApplicationContext'
    // ConfigurableApplicationContext has the following method: refresh(), close() and shutdown()
    @Autowired  // hence we are overriding the default ApplicationContext with ConfigurationApplicationContext, we need this to be autowired
    private ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        int index = (int) ((Math.random())*(28-1)+1); // SELECT COUNT(*) FROM room; -> 28 rooms;
        // now randomly pick any roomID between 1 to 28 and pass it to rabbitMQ as payload for room cleanign service sequest

        // Call the AsyncPayload
        AsyncPayload payload = new AsyncPayload();
        payload.setId(index);   // in the payload, set the randomly seleted room for roomCleaning service request
        payload.setModel("ROOM"); // Define the payload type as "ROOM", else it will notify invalid Service Request raised or objectType cant recognized

        // Finally pass the payload to my local RabbitMQ server with the RabbitMQ Template we designed
        // Requires: exchange, routingKey and pass the payload as String
        rabbitTemplate.convertAndSend("operations", "hotel.room.cleaner", objectMapper.writeValueAsString(payload));

        // As ConfigurableApplicationContext not only serve the beans at the application runtime, also manage its lifecycle(initialization and destruction)
        // we need to close the context after a payload if passed to RabbitMQ
        context.close(); // let the Rabbit Shutdown this Application Conext once done
    }
}
