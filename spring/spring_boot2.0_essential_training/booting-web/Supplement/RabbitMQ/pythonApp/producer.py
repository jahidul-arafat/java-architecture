# import the packages
import pika, os, logging

# Parse CLOUDAMQP_URL (fallback to localhost)
amqpURL = "amqps://zzsmnpzo:NNpdM-GI3L-05hqHerAdGACVUw97qNJE@shrimp.rmq.cloudamqp.com/zzsmnpzo"
params = pika.URLParameters(amqpURL)
# print(params) # <URLParameters host=shrimp.rmq.cloudamqp.com port=5671 virtual_host=zzsmnpzo ssl=True>

# establish the connection to the CloudAMQP Server
# default socket timeout is 0.25s; to avoid connection timeout, raise this to 5s
params._socket_timeout=5
connection = pika.BlockingConnection(params) # Blocking Connection establishes a connection with the RabbitMQ server

# Create a channel in the connection
ch = connection.channel() # creates a channel in the TCP Connection
# with the channel, create a queue named "pdfprocess"
ch.queue_declare(queue='pdfprocess') # Declare a Queue; this is the Queue to which the message will be delivered

# publish the message in direct exchange
ch.basic_publish(exchange='',
                 routing_key='pdfprocess',
                 body='User Information') # default exchange identified by ""; means Message{routeKey} == Queue{routeKey}
print("[x] Message sent to consumer")

# Close the Connection
connection.close()


