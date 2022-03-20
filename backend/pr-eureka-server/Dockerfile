FROM openjdk:11

VOLUME /tmp

COPY target/*.jar pr-eureka-server.jar

ENTRYPOINT ["java", "-jar", "/pr-eureka-server.jar"]