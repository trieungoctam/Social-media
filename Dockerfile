# Use the official OpenJDK 17 as the base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app
# Copy the dependencies file to the working directory
COPY build/libs/facebook-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 2163

# Set the default command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "./app.jar"]