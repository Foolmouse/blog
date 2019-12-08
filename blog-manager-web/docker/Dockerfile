FROM openjdk:8-jre
MAINTAINER Luoju <luoju@coding.net>

ENTRYPOINT ["/usr/bin/java", "-jar", "home/blog/blog-user-web/target/user-web.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib           /usr/share/myservice/lib
# Add the service itself
#ARG JAR_FILE
#ADD target/${JAR_FILE} /usr/share/myservice/myservice.jar