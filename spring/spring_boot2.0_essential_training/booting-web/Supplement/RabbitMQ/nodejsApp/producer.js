// Step-0: Load AMQP Library
// and access the callback-based API
// npm install amqplib
var amqp = require('amqplib/callback_api');

// Step-1: get the CloudAMQP server URL to which to connect and listen
var amqpURL = "amqps://zzsmnpzo:NNpdM-GI3L-05hqHerAdGACVUw97qNJE@shrimp.rmq.cloudamqp.com/zzsmnpzo";

//
/*
    Step-2:
    (a) setup the connection to the CloudAMQP server with the URL defined
        (b) Create a channel
            (c) create a queue named 'CloudAMQP';
            (d) create a MESSAGE which will be PUBLISHED
            (e) bind the queue in the channel if it already not; else skip
            (f) At an interval of 2s, PUBLISH the message to the queue

 */
amqp.connect(amqpURL, function (err, conn) {
    conn.createChannel(function (err,ch) {
        var q = "CloudAMQP";
        var msg = "Hello Node RabbitMQ ";
        var i=0;
        ch.assertQueue(q, {durable: true});
        setInterval(function () {
            ch.sendToQueue(q, Buffer.from(msg+i));
            i++;
        }, 2000);
    });
});


