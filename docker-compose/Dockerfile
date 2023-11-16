FROM amazoncorretto:17.0.4

WORKDIR /app

COPY sensors.monitor.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]