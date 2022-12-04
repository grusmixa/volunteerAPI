FROM amazoncorretto:17-alpine-jdk
COPY target/*.jar volunteerServer.jar
ENTRYPOINT ["java","-jar","/volunteerServer.jar"]