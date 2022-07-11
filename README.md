# Free Backend

Below are the instructions on how to run the application:

## Prerequisites

* JDK17
* Maven (Can be the IntelliJ-built in one)
* https://apilayer.com/marketplace/exchangerates_data-api API Key
**Note** that without an API key the application will start but exchange-related functionalities will not work.

## Running the application

### Through Maven:
Run `spring-boot:run -Dspring-boot.run.profiles=dev -Dexchange.apikey={APIKEY}` where APIKEY is the API Key from the exchange rates data API.

### Through Docker:
https://hub.docker.com/repository/docker/waffaru/free-application
Run `docker run --name free -p 8080:8080 -e APIKEY={APIKEY} -d waffaru/free-application`
The docker container will start on port 8080. remove `-d` flag to see console output.

## Testing Application
Simply run `mvn test` or the test lifecycle job inside IntelliJ.

## Packaging Application
Run `mvn package`
### Dockerization
Run `docker build -t {image-name} .` where image-name is the image name you want to give to the image.
**(Optional)** Run `docker push {image-name}` to push it into Dockerhub image registry (or other registries depending on the target image URL, could be GCP).

## Testing the Endpoints

To test the endpoints you can use the Postman collection file to import premade requests that can be used in the application. There's two requests for each endpoint, showcasing a happycase and a failing case.