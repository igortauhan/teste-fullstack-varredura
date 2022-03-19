FROM openjdk:11

VOLUME /tmp

COPY target/*.jar pr-search.jar

ENTRYPOINT ["java", "-jar", "/pr-search.jar"]