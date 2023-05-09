FROM eclipse-temurin:17-jdk-alpine
ADD target/rede-social-*.jar rede-social.jar
ENTRYPOINT ["java", "-jar", "/rede-social.jar"]