
FROM openjdk:8

RUN ls

COPY .  .

RUN ls

RUN ./gradlew clean build

RUN ls

# copy the packaged jar file into our docker image
COPY ./build/libs/product-service-0.0.1-SNAPSHOT.jar /product-service.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/product-service.jar"]