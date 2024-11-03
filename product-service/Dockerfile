FROM openjdk:17-oracle
WORKDIR /app
COPY target/product-service-0.0.1-SNAPSHOT.jar product-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "product-service.jar"]

