FROM maven:latest
COPY ./zap-trial .
RUN mvn --batch-mode --update-snapshots package
CMD mvn spring-boot:run
