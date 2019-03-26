FROM openjdk:8
VOLUME /tmp
ADD /var/lib/jenkins/workspace/practic/target/docker-app-port.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8081
ENTRYPOINT ["sh","-c","java -jar /app.jar"]