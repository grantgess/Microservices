FROM openjdk:17-jdk

WORKDIR /app

COPY target/order-service.jar /app/order-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "order-service.jar"]