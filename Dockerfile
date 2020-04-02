FROM adoptopenjdk:11-jdk-openj9-bionic AS build-project
ADD . ./gateway
WORKDIR /gateway
RUN chmod +x mvnw
RUN ./mvnw clean install -DskipTests

FROM adoptopenjdk:11-jdk-openj9-bionic
EXPOSE 8080
WORKDIR /app
COPY --from=build-project ./gateway/target/gateway-*.jar ./gateway.jar
ENV ARTIFACT_NAME=gateway.jar
