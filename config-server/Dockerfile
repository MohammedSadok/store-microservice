FROM openjdk:17-oracle
WORKDIR /app
COPY target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "config-server.jar"]