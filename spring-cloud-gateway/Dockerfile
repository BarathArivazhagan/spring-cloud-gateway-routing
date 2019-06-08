FROM openjdk:8-jdk-alpine
RUN adduser -D demo 
USER demo
VOLUME /tmp
ADD target/spring-cloud-gateway-*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]