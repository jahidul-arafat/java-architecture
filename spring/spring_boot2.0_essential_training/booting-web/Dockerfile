FROM maven:3.8.6-amazoncorretto-17 as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/

# Comment
RUN echo 'we are running some # of cool things'
RUN echo hello \
    #comment
    world \


RUN mvn clean package
COPY target/booting-web-${VERSION}.jar target/application.jar