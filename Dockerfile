FROM maven:3.6.3-adoptopenjdk-8
EXPOSE 8080
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} metric_app.jar
ENTRYPOINT ["java","-jar","/metric_app.jar"]