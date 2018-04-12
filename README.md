[![Build Status](https://travis-ci.org/systelab/seed-springboot.svg?branch=master)](https://travis-ci.org/systelab/seed-springboot)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7ce4e563c45b4d09a975d61bed7d5d50)](https://www.codacy.com/app/alfonsserra/seed-springboot?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=systelab/seed-springboot&amp;utm_campaign=Badge_Grade)
[![Known Vulnerabilities](https://snyk.io/test/github/systelab/seed-springboot/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/systelab/seed-springboot?targetFile=pom.xml)

# `seed-springboot` — Seed for Spring Boot Systelab projects

This project is an application skeleton for a typical [Spring Boot][sboot] backend application. You can use it
to quickly bootstrap your projects and dev environment.

The seed contains a Patient Management sample application and is preconfigured to install the JEE
framework and a bunch of development and testing tools for instant development gratification.

The app doesn't do too much, just shows how to use different standards and other suggested tools together:

* Spring Boot
* Spring Boot Web
* Spring Boot Data JPA
* [JWT][jwt]
* [CORS][cors]
* [Swagger][swagger]
* Spring Boot Security
* Spring Boot Test
* [Allure][allure] with [JUnit][junit]

## Getting Started

To get you started you can simply clone the `seed-springboot` repository and install the dependencies:

### Prerequisites

You need [git][git] to clone the `seed-springboot` repository.

You will need [Java™ SE Development Kit 8][jdk-download] and [Maven][maven].

### Clone `seed-springboot`

Clone the `seed-springboot` repository using git:

```bash
git clone https://github.com/systelab/seed-springboot.git
cd seed-springboot
```

### Install Dependencies

In order to install the dependencies and generate the Uber jar you must run:

```bash
mvn clean install
```

### Run

To launch the server, simply run with java -jar the generated jar file.

```bash
java -jar seed-springboot-1.0.jar
```

## API

You will find the swagger UI at http://localhost:8080/swagger-ui.html

## Docker

### Build docker image

There is an Automated Build Task in Docker Cloud in order to build the Docker Image. 
This task, triggers a new build with every git push to your source code repository to create a 'latest' image.
There is another build rule to trigger a new tag and create a 'version-x.y.z' image

You can always manually create the image with the following command:

```bash
docker build -t systelab/seed-springboot . 
```

### Run the container

```bash
docker run -e 8080:8080 systelab/seed-springboot
```

The app will be available at http://localhost:8080/swagger-ui.html




[git]: https://git-scm.com/
[sboot]: https://projects.spring.io/spring-boot/
[maven]: https://maven.apache.org/download.cgi
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads
[JEE]: http://www.oracle.com/technetwork/java/javaee/tech/index.html
[jwt]: https://jwt.io/
[cors]: https://en.wikipedia.org/wiki/Cross-origin_resource_sharing
[swagger]: https://swagger.io/
[allure]: https://docs.qameta.io/allure/
[junit]: https://junit.org/junit5/


