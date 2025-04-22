FROM amazoncorretto:17-alpine-jdk

COPY target/alertas_api-0.0.1-SNAPSHOT.jar /alertas_api-v1.jar

ENTRYPOINT ["java", "-jar", "/alertas_api-v1.jar"]
