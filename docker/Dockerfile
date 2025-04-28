# Use OpenJDK 21 as a base image
FROM openjdk:21-jdk-slim AS builder

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory of your project into the container
COPY target/*.jar app.jar

# Expose the port on which your app will run
EXPOSE 8080

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
