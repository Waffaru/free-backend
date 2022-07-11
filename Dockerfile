FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
ENV APIKEY=$APIKEY
COPY ${JAR_FILE} app.jar
ENTRYPOINT java -Dexhcange.apikey=$APIKEY -jar /app.jar