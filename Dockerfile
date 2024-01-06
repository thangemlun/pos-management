FROM maven:3.9.0-eclipse-temurin-11-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jre
EXPOSE 8080
WORKDIR /app
COPY ./target/pos-management-0.0.1.jar .
CMD ["java", "-jar", "pos-management-0.0.1.jar"]