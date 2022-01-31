# Firebase To-Do App

This is the Spring Boot backend for a fullstack web application. Application uses Google Firebase Firestore as its data source. The frontend project is located [here](https://github.com/Noxob/angular-todoapp-ui). Project uses Spring Security for its security architecture and implements JWT authentication. API endpoints are documented via Swagger.

## Building:

Before building this app, you need to create a Firebase project and feed the application.properties with the proper information. Required infos are your app id and private key. App id is created alongside your Firebase project, you can find it on Firebase Dashboard under `Project Settings > General > Project ID`. Private key is generated from Firebase Dashboard under `Project Settings > Service Accounts > Generate new private key` which gives you a JSON file. You need to put that in your project classpath and specify its location in the `application.properties` file under `spring.cloud.gcp.firestore.credentials.location` key.

In order to build the app, you need to run `mvn clean install`, this will create a JAR file in the "target" directory.

## Testing:

When you run `mvn clean install`, the tests will run automatically. 

## Running the app:

You can start the Spring Boot application which was created in the "target" directory (by running `mvn clean install`) via `java -jar <JAR_FILE_NAME>` command.

## Run as Docker Container:

In order to run the project as a docker container, execute the command below in the root directory of the project:

>docker-compose up

This will setup the frontend and the backend. (These two images can be found separately [here](https://hub.docker.com/u/noxob))

## Swagger:

Swagger endpoint is `http://localhost:8080/swagger-ui/` by default.

## Frontend:

Frontend repository can be found [here](https://github.com/Noxob/couchbase-demo-todoapp-ui).

## Containerize:

In order to containerize you need to run `createdockerimages.txt` line by line. This will create a container containing both couchbase server and our backend.
