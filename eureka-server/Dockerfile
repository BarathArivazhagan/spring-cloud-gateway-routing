FROM openjdk:8-jdk-alpine
RUN adduser -D demo 
USER demo
ADD target/eureka-server-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

