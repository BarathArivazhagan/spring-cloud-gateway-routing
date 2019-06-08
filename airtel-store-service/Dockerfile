FROM openjdk:8-jdk-alpine
RUN adduser demo
USER demo
VOLUME /tmp
ADD target/airtel-store-service-*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]