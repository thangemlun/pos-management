FROM openjdk:11-jre
WORKDIR /opt
COPY post-management/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]