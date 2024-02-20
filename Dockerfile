FROM maven:3.8.4-openjdk-17 as build
COPY diploma-postgres/src src
COPY diploma-postgres/pom.xml .
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:17
COPY --from=build /target/DiplomaAirline-0.0.1-SNAPSHOT.jar /target/DiplomaAirline-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/target/DiplomaAirline-0.0.1-SNAPSHOT.jar"]