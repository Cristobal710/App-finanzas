# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the build artifact (your JAR file) into the container
# Assuming the JAR file is in the 'build/libs' directory after running 'gradle build'
COPY build/libs/CRUD-0.0.1-SNAPSHOT.jar CRUD-0.0.1-SNAPSHOT.jar

# Expose the port your API will run on (default Spring Boot port is 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "CRUD-0.0.1-SNAPSHOT.jar"]

