FROM openjdk:11
COPY target/SpringBootReveiw-0.0.1-SNAPSHOT.jar server.jar
ENTRYPOINT ["java", "-jar", "/server.jar"]