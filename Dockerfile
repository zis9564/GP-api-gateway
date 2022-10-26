FROM openjdk:11-jdk
VOLUME /tmp

COPY api-gateway/build/libs/gp-gateway-0.1.0.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar",""]