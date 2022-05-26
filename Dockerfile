FROM maven:latest
COPY ./zap-trial .
CMD mvn spring-boot:run
