FROM maven:3.8.2-jdk-8
COPY ./zap-trial .
mvn package -Dmaven.test.skip
CMD mvn spring-boot:run