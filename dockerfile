FROM amazoncorretto:11 AS build
WORKDIR /newspaper
COPY ./ ./

RUN ["./mvnw", "install"]
RUN ["./mvnw", "package"]

FROM build AS deploy
WORKDIR /exec
COPY --from=build /newspaper/target/newspaper-service-0.0.1-SNAPSHOT.jar ./executable.jar
CMD ["java", "-jar", "executable.jar"]