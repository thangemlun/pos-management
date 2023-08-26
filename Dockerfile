FROM maven:3.9.0-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /opt
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]