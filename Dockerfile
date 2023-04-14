# Base Alpine Linux based image with OpenJDK JRE only
FROM gradle:8.1.0-jdk17
EXPOSE 8080
COPY target/ms-backend-0.0.1-SNAPSHOT.jar /ms-backend.jar
# specify default command
CMD ["java", "-jar", "-Dspring.profiles.active=test", "/ms-backend.jar"]
