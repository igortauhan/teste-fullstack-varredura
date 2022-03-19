FROM openjdk:11

VOLUME /tmp

EXPOSE 8761

COPY target/*.jar pr-eureka-server.jar

ENTRYPOINT ["java", "-jar", "/pr-eureka-server.jar"]