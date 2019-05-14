FROM openjdk:8-alpine

MAINTAINER karan rathore <karanr15.rathore@gmail.com>

ENV JAVA_OPTS=""

COPY build/libs/ark-backend-employee-0.0.1-SNAPSHOT.jar ark-backend-employee-0.0.1-SNAPSHOT.jar

CMD [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=docker -jar app.jar" ]
