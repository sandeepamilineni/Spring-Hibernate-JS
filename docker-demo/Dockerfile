FROM alpine:3.7
ADD /target/docker-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java" , "-jar", "app.jar"]
EXPOSE 9002