# Stage 1: Build the application
FROM maven:3-openjdk-17-slim AS build

LABEL maintainer="NacerkH"

# Create and set the working directory
WORKDIR /workspace

# Copy the pom.xml and download dependencies
COPY pom.xml /workspace
RUN mvn -B -f pom.xml dependency:go-offline

# Copy the project source
COPY src /workspace/src

# Build the application
RUN mvn -B -f pom.xml clean package -DskipTests

# Stage 2: Package the application
FROM openjdk:17-alpine

# Create the log directory and set permissions
RUN mkdir -p /var/log/spring-boot && chown -R 1000:1000 /var/log/spring-boot



# Copy the jar from the build stage
COPY --from=build /workspace/target/*.jar /app.jar

# Expose the application port
EXPOSE 8090

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
