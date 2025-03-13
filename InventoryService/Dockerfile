FROM openjdk:17-jdk

WORKDIR /app

COPY target/*.jar /app/inventory-service.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "inventory-service.jar"]