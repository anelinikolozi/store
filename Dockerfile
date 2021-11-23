FROM openjdk:17-slim
COPY /target/store-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "app.jar"]