FROM openjdk:14-jdk-alpine
MAINTAINER upgrad
ADD ./target/api-gateway.jar /opt/app/api-gateway.jar
WORKDIR /opt/app
ENV PATH="${PATH}:${JAVA_HOME}/bin"
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/opt/app/api-gateway.jar"]
