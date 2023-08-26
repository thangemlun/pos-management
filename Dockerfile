FROM openjdk:11-jre
ENV PORT 8080
ENV CLASSPATH /opt/lib
EXPOSE 8080

COPY target/docker-pos-management-0.0.1.jar pos-management-0.0.1.jar
ENTRYPOINT ["java","-jar","/pos-management-0.0.1.jar"]