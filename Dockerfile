FROM openjdk:11-jre
EXPOSE 8080
WORKDIR /app
COPY ./target/pos-management-0.0.1.jar .
CMD ["java", "-jar", "pos-management-0.0.1.jar"]