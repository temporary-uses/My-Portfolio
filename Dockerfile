# Use Java 17 (Spring Boot standard)
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (Render provides PORT)
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "target/*.jar"]
