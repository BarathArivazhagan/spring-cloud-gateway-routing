FROM openjdk:17-jdk-slim-buster
RUN useradd demo 
USER demo
ADD target/eureka-server-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

