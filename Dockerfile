FROM codingcorp-docker.pkg.coding.net/registry/public/java:8-jdk
COPY ./blog-user-web/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]