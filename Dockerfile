# syntax=docker/dockerfile:1

FROM maven:3.9.2 AS builder
LABEL author='Shahriyar Rahimov' email='shahriyar_rahimov@live.com'
WORKDIR /employee_mvc_app

COPY src ./src
COPY pom.xml ./pom.xml

RUN mvn clean install -DskipTests
RUN mvn dependency:resolve
RUN mvn package -Dmaven.test.skip=true


FROM openjdk:20

WORKDIR .
COPY --from=builder /employee-app/target/employee-0.0.1-SNAPSHOT.jar /employee-0.0.1-SNAPSHOT.jar

EXPOSE 8080:8080
ENTRYPOINT ["java","-jar","/employee-0.0.1-SNAPSHOT.jar"]

CMD ["./mvnw", "spring-boot:run"]

