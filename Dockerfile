FROM gradle:8.13-jdk23 AS build
WORKDIR /app

COPY build.gradle settings.gradle ./
RUN gradle build --no-daemon || return 0
COPY . .
RUN gradle bootJar --no-daemon

FROM eclipse-temurin:23-jdk-alpine
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
