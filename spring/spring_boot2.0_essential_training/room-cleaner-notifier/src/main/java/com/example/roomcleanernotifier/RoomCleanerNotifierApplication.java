package com.example.roomcleanernotifier;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomCleanerNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomCleanerNotifierApplication.class, args);
	}

	// The below 3x variables and 3x beans copied from the CONSUMER // module: booting-web
	private static final String QUEUE_NAME = "room-cleaner";    // queue name where we gonna PUBLISH the payload
	private static final String EXCHANGE_NAME="operations";     // RabbitMQ broker exchange // Every Queue will be bind to atleast one broker; otherwise that broker would not receive any message
	private String ROUTING_KEY = "hotel.room.cleaner";

	// Bean-1: Create the AMQP Queue
	@Bean   // Bean Factory serves the bean at the runtime of the application and Application Context act as a wrapper
	public Queue queue(){
		// Note: Durable RabbitMQ queues are those which can withstand a RabbitMQ restart.
		// If a RabbitMQ queue is not durable, all the queued messages will be lost if RabbitMQ is shutdown for any reason
		// For queued messages to survive restarts, both of these configurations must be true
		return new Queue(QUEUE_NAME, false); // durable false means, this Queue doesnt need to survive RabbitMQ restart
	}

	// Bean-2: Create the Broker Exchange
	@Bean
	public TopicExchange exchange(){
		return new TopicExchange(EXCHANGE_NAME); // Exchange will bind the Queue within the channel on the Connection to the RabbitMQ server
	}

	// Bean-3: Bind the Queue to the Exchange
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY); // Bind the Queue to Exchange with routingKey
	}


}
