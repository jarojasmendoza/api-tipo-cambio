FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY "build/libs/api-tipo-cambio-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
