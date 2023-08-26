FROM eclipse-temurin:11-jdk-alpine
VOLUME /tmp
COPY --from=build target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080