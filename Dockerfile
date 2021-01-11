FROM alpine:latest

EXPOSE 8081

RUN apk --update --no-cache add ca-certificates openjdk11

RUN mkdir /app
ADD ./build/libs/farmacia-*all.jar /app/farmacia.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/farmacia.jar"]