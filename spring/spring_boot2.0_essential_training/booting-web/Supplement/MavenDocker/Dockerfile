FROM maven:3.6.3-openjdk-11-slim as BUILDER
ARG VERSION=0.0.1-SNAPSHOT

# src files will be copied to the Docker Container /build/ dicrectory
# pom.xml will also be copied to the same directory
# make sure the pom.xml using sprinf-framweork 2.5.4 as Intellij 21.02 beyond support start from this version

WORKDIR /build/
ADD pom.xml /build/pom.xml
COPY src /build/src/

# Build the JAR including the packages
RUN mvn clean package

FROM openjdk:11.0.8-jre-slim
WORKDIR /app/

COPY --from=BUILDER /build/target/booting-web-0.0.1-SNAPSHOT.jar /app/application.jar
CMD java -jar /app/application.jar


