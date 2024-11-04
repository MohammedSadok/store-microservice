FROM openjdk:17-oracle
WORKDIR /app
COPY target/customer-service-0.0.1-SNAPSHOT.jar customer-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "customer-service.jar"]

