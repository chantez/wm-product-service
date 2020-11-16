
FROM openjdk:8

RUN ls

COPY .  .
COPY gradle/wrapper/gradle-wrapper.properties  .



RUN ls

RUN ./gradlew clean build

RUN ls build
RUN ls build/libs

# copy the packaged jar file into our docker image
RUN cp build/libs/product-service-0.0.1-SNAPSHOT.jar product-service.jar

PORT=8080
EXPOSE $PORT
# set the startup command to execute the jar
CMD ["java", "-jar", "/product-service.jar"]
