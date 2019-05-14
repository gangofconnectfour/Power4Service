FROM maven:3.6.1-jdk-8-alpine

ARG MAVEN_VERSION=3.6.1

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
#RUN mvn -f /usr/src/app/pom.xml clean compile

WORKDIR /usr/src/app
RUN mvn -N io.takari:maven:wrapper -Dmaven=${MAVEN_VERSION}
RUN mvn --show-version --errors --batch-mode test-compile dependency:go-offline
