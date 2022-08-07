## builder
FROM adoptopenjdk:11-jdk-hotspot as builder
ENV APP_HOME=/apps/CultivosUnidos
WORKDIR ${APP_HOME}/service/app
COPY . .

RUN ./gradlew bootJar


## target
FROM adoptopenjdk:11-jre-hotspot as release
ENV APP_HOME=/apps/CultivosUnidos
WORKDIR ${APP_HOME}/service/app

COPY --from=builder ${APP_HOME}/service/app/build/libs/*.jar cultivosunidoservice.jar

EXPOSE 8080 5432

VOLUME /app/logs

ENTRYPOINT ["java","-jar","cultivosunidoservice.jar"]