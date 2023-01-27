# syntax=docker/dockerfile:1
FROM openjdk:11-jre-slim

ENV FORMAT=dot

ARG GIT_REVISION=local

LABEL GIT_REVISION=$GIT_REVISION

WORKDIR /app
COPY target/capsyl-0.1-SNAPSHOT.jar ./
CMD ["sh", "-c", "java -jar capsyl-0.1-SNAPSHOT.jar /IO/input $FORMAT > /IO/output"]
