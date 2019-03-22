FROM openjdk:8
ADD target/docker-app.jar division.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","docker-app.jar"]