FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/foodapp-0.0.1-SNAPSHOT.jar
COPY ./build/libs/foodapp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]