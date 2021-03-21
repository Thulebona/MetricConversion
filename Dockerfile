FROM maven:3.6.3-adoptopenjdk-8 as builder
WORKDIR /build

COPY pom.xml /build
COPY src /build/src
RUN mvn clean package

FROM maven:3.6.3-adoptopenjdk-8

WORKDIR /app
COPY --from=builder /build/target/*.jar /app/metric_app.jar
ENTRYPOINT ["java","-jar","metric_app.jar"]
