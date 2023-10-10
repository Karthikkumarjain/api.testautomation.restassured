FROM adoptopenjdk/maven-openjdk11
COPY src testframework/api/src
COPY pom.xml testframework/api/pom.xml
WORKDIR testframework/api
ENTRYPOINT mvn clean test -Psystem-tests