FROM openjdk:11

VOLUME /tmp

EXPOSE 8080

COPY target/*.jar pr-gateway.jar

ENTRYPOINT ["java", "-jar", "/pr-gateway.jar"]