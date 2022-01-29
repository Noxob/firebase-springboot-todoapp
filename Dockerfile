FROM openjdk:8
COPY ./target/todoapp-0.0.1-SNAPSHOT.jar spring-boot.jar
ENTRYPOINT ["/bin/sh","-c","java -jar /spring-boot.jar"]