From eclipse-temurin:21-jdk
WORKDIR /app
COPY . .
Run chmod =x mvnw
Run ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/ backend-0.0.1-SNAPSHOT.jar"]