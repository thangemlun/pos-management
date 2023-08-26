FROM openjdk:11-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

RUN docker build --tag=pos-management:latest -f Dockerfile .
RUN docker run -p8080:8080 pos-management:latest