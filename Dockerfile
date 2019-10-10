FROM openjdk:8-jre-alpine
RUN mkdir /opt/apps
WORKDIR /opt/apps/
COPY build/libs/employee-0.0.1-SNAPSHOT.jar   .
EXPOSE 8080:8080
CMD ["java", "-jar", "employee-0.0.1-SNAPSHOT.jar"]