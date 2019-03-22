FROM openjdk:8
ADD target/docker-app-port.jar practice.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","docker-app.jar"]