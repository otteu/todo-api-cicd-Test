FROM openjdk:17
COPY ./app-0.0.1-SNAPSHOT.jar /usr/src/myapp/app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${spring_profiles_active}", "-Dapplication.role=${application_role}", "-jar", "/usr/src/myapp/app.jar"]
EXPOSE 9090
WORKDIR /usr/src/myapp