FROM openjdk:11-jdk
VOLUME /tmp

COPY api-gateway/build/libs/api-gateway.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar",""]