FROM openjdk:8-jdk-alpine
COPY target/metric-imperial-converter-0.0.1.jar metric-imperial-converter-0.0.1.jar
ENTRYPOINT ["java","-jar","/metric-imperial-converter-0.0.1.jar"]