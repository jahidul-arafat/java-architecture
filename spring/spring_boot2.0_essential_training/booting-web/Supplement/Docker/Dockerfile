# The latest version pf Ubuntu is used as the base image for this Dockerfile
FROM ubuntu:latest

# Set the author field fof the generated image
MAINTAINER jahidul.arafat@oracle.com

# RUN is an image build step
# Run some command inside the docker container
# Update the repo and install package <curl>
# Final clean the cache
RUN apt-get update && apt-get install -yq curl
RUN apt-get clean

# CMD is the command the container executes by default when you launch the built image
# Once the generated image get lunched
# execute the following commands
# a. get the top processes
# b. list all contents into the directory
# If a Dockerfile has multiple CMDs, it only applies the instructions from the last one.
CMD touch hello.txt
CMD echo "hello" >> hello.txt
CMD echo $HOME >> hello.txt

# Set the Working directory inside the docker image
# Also set some environment variable
WORKDIR /root
ENV VAR1 version
ADD run.sh /root/run.sh
RUN chmod +x run.sh

# Set the entry point and arguments for the generated image
# If CMD provides the default arguments for ENTRYPOINT, both CMD and ENTRYPOINT must be JSON array formatted....
# ENTRYPOINT has two format
# Format_01 (exec form:Preferred): ENTRYPOINT ["executable", "param1", "param2"]
# Format_02 (shell form): ENTRYPOINT command param1 param2
# executable is defined with ENTRYPOINT, while CMD specifies the default parameter.
#ENTRYPOINT ["./run.sh"]
#CMD ["arg1"]
#CMD ["arg2"]
ENTRYPOINT ["echo", "Hello"]
#CMD ["World"]

