FROM openjdk:8-jdk-alpine
MAINTAINER BARATH
VOLUME /tmp
ADD target/jio-store-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]