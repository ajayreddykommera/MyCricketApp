FROM openjdk:latest
MAINTAINER k.ajayr96@gmail.com
COPY target/app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
