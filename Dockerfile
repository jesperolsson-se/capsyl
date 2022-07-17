# syntax=docker/dockerfile:1
FROM openjdk:11-jre-slim

WORKDIR /app
COPY target/capsyl-0.1-SNAPSHOT.jar ./
CMD ["sh", "-c", "java -jar capsyl-0.1-SNAPSHOT.jar /IO/input"]
