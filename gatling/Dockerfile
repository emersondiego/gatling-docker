FROM openjdk:8-jdk-slim

ADD ./target/gatling-moip-inflow-1.0.2-SNAPSHOT.jar /app/gatling.jar

RUN sh -c 'touch /app/gatling.jar'

WORKDIR /app

ENTRYPOINT [ "java", "-jar", "gatling.jar" ]
