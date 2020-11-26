[![CircleCI build master branch][circleci-badge]][circleci-link]

# Gradle and Spring Boot with Jersey Application Skeleton
Basic Gradle `v6.7.1` multi-source-set project setup for Spring Boot with Jersey (JAX-RS) web applications.

The project skeleton helps to be up and running quickly without wasting too much time on setting up & wiring things from scratch. Also, it serves as a refresher for basic things like:
* Gradle project setup boiler plate
* Configuring Spring Boot & Jersey (FYI: Using Jersey is not a `must`. Spring MVC is a more native choice when using Spring Framework)
* Writing a unit test using a JUnit 4.x.x
* Writing a unit test using mocks (i.e.: Mockito runner)
* Writing a Spring Boot based tests (i.e.: tests annotated with `@SpringBootTest`)


## Setup

* Spring Boot version: `v2.3.5.RELEASE`
* `/api/*` is the Jersey base path that serves as the base URI for all resource URIs provided by `@Path`

## Running

* Command `./gradlew bootRun` starts Tomcat on port `8080`
* The following `RESTful` APIs are available upon service start-up:
  * `GET` `http://localhost:8080/api/v1/greetings`
  * `GET` `http://localhost:8080/api/v1/greetings/{id}` (choose an `id` from `1`, `2` or `3`)
  * `POST` `http://localhost:8080/api/v1/greetings`
    * `curl -H "Content-Type:application/json"-X POST --data '{"text": "Privet!"}' http://lcalhost:8080/api/v1/greetings`
* Spring Boot Actuator exposes two APIs:
  * `http://localhost:8080/actuator/health`
  * `http://localhost:8080/actuator/metrics`

## Testing

* Command `./gradlew test` runs unit tests
* Command `./gradlew componentTest` runs component tests

## License
MIT. See LICENSE for details


<!-- references -->

[circleci-badge]: https://circleci.com/gh/azagniotov/gradle-spring-boot-jersey-setup.svg?style=shield
[circleci-link]: https://circleci.com/gh/azagniotov/gradle-spring-boot-jersey-setup

