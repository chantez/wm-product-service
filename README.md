# Lider Challenge

# Service for searching products

The service looks for products in a mongo database querying the data using id, brand and descriptions

### Build

Build the artifact using the gradle command which is inside this project:
```sh
$ ./gradlew clean build
```

### Execution

Execute the service:
```sh
$ java -jar build/libs/product-service-*.jar
```

If you only want to use docker, you can generate the image and run the container using this:
```sh
$ docker build --tag wm-product-service .
$ docker run --publish 8080:8080 --name bb wm-product-service

