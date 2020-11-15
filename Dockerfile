
FROM openjdk:8-jre-alpine3.9

RUN ./gradlew clean build

# copy the packaged jar file into our docker image
COPY build/libs/products-service-0.0.1-SNAPSHOT.jar /products-service.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/products-service.jar"]