# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Install Gradle (if necessary), or use the Gradle wrapper to build the project
RUN ./gradlew build

# Expose the port your API will run on (default Spring Boot port is 8080)
EXPOSE 8080

# Run the JAR file after the build is complete
ENTRYPOINT ["java", "-jar", "build/libs/CRUD-0.0.1-SNAPSHOT.jar"]
