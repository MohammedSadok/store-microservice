FROM openjdk:17-oracle
WORKDIR /app
COPY target/order-service-0.0.1-SNAPSHOT.jar orders.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "orders.jar"]
