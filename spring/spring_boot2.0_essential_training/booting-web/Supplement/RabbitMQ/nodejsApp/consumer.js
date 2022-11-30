// Step-0: Load AMQP Library
// and access the callback-based API
var amqp = require('amqplib/callback_api');

// Step-1: get the CloudAMQP server URL to which to connect and listen
var amqpURL = "amqps://zzsmnpzo:NNpdM-GI3L-05hqHerAdGACVUw97qNJE@shrimp.rmq.cloudamqp.com/zzsmnpzo";

//
/*
* Step-2: pop the message from the queue
* */

amqp.connect(amqpURL, function(err,conn){
    conn.createChannel(function(err,ch){
        var q = 'CloudAMQP';
        ch.assertQueue(q, {durable: true});
        console.log("<- Waiting for messages in QUEUE [%s]. To exit press CTRL+C",q);
        ch.consume(q, function(msg){
            console.log("<- Received %s", msg.content.toString());
        }, {noAck: true});
    });
});