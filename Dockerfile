FROM maven:3.9.0-eclipse-temurin-11-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
VOLUME /tmp
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080