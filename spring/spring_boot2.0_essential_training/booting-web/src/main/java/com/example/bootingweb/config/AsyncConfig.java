package com.example.bootingweb.config;

import com.example.bootingweb.async.RoomCleanerListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Design the RabbitMQ Producer-Consumer
 * Requires:
 * (a) Setup a Connection
 * (b) Channel
 * (c) Excahnge
 * (d) Queue
 *
 * Hints: Message{RoutingKey}== Queue{RoutingKey}
 */
@Configuration
public class AsyncConfig {
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

    // Bean-4: Create a MessageListenerAdapter
    @Bean
    public MessageListenerAdapter listenerAdapter(RoomCleanerListener listener){
        return new MessageListenerAdapter(listener, "receiveMessage");
    }

    // Bean-5: The Consumer Bean

    /**
     * Require Explanations
     * As we have set the Queue and Exchange and Bing the Queue with an exchange to setup the pipeline for Async Queue of the messages
     * The next step is to Design a MessageListenerAdapter which will get the Payload from AsyncPayload class and process it via method <requestMessage> where we have written the business logics
     * Now, If we check mark, we have the followings at hand
     *  - A Queue
     *  - A TopicExchange
     *  - Binding(Queue, Exchange)
     *  - A MessageListenerAdapter for RoomCleanerListener
     * Now, we have to put the Async payload into the queue and let our MessageListnerAdapter Subscribe to that queue for consumption
     * @param connectionFactory
     * @param listenerAdapter - Connection Connecting the RoomClinerListener which validate the roomId and roobObjectType and return
     *                        this remains in receivingMode
     * @return
     */

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(QUEUE_NAME);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);

        return simpleMessageListenerContainer;

    }






}
