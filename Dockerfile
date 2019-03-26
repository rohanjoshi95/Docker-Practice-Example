FROM openjdk:8
VOLUME /tmp
ADD build/libs/docker-app-port.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8081
ENTRYPOINT ["sh","-c","java -jar /app.jar"]