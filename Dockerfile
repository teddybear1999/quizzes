FROM openjdk:17-jdk

WORKDIR /app

COPY target/myapp.jar /app/

EXPOSE 8080

CMD ["java", "-jar", "myapp.jar"]
