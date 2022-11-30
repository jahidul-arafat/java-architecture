import time
import pika, os

# Worker function
def pdf_process_funciton(msg):
    print(" PDF Processing")
    print(" [x] Received "+ str(msg))

    time.sleep(5)
    print(" PDF Processing finished")
    return


# Function called for incoming messages
# create a function which is called on incoming messages
def callback(channel, method, properties,payload):
    pdf_process_funciton(payload)


# setup the conenction, channel, queue
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

# setup the subscription on the queue
ch.basic_consume('pdfprocess', callback, auto_ack=True)

# start consuming (blocks)
ch.start_consuming()
connection.close()
