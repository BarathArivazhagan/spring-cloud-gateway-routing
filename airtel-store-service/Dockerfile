FROM openjdk:17-jdk-slim-buster
RUN useradd demo
USER demo
VOLUME /tmp
ADD target/airtel-store-service-*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
