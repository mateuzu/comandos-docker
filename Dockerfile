FROM openjdk:17
VOLUME /tmp
ADD ./target/test-docker-0.0.1-SNAPSHOT.jar test-docker.jar
ENTRYPOINT [ "java", "-jar", "/test-docker.jar" ]