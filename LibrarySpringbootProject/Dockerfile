

FROM maven:3.8.3-openjdk-17 AS build
COPY ..
RUN mvn clean package -DskipTests
FROM openjdk:17-jdk-slim
COPY --frombuild target/Library-Management-Project-0.0.1-SNAPSHOT.jar Library-Management-Project.jar
EXPOSE 8080
ENTRYPOINT ["java", "jar","Library-Management-Project.jar"]

