FROM openjdk:22

WORKDIR /app

COPY /target/db-connection.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java" , "-jar" , "app.jar"]