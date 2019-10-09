
# Employee Service
This is the service to CRUD the employee. Only a POC.

## Technologies, FrameWorks, Concepts e Architecture

* Java
* JPA
* REST
* GIT
* Docker
* Spring Boot
* MVC
* Gradle
* Flyway
* PostgreSQL

## Prerequisites

* [Git](https://git-scm.com/downloads)
* [Java 1.8](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html) select JDK for your platform
* IDE ([VSCode](https://code.visualstudio.com/download), [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows), [Eclipse](https://www.eclipse.org/downloads/))
* Latest version [Gradle](https://gradle.org/releases/)
* [Postman](https://www.getpostman.com/downloads/)
* [Docker](https://www.docker.com/products/docker-desktop) optional

## Setup
From a terminal, open on the root of the project

```
git clone https://github.com/TiagoMarquesTR/employee.git
cd employee
```

## Build

```
.\gradlew clean build
```

## Run

```
.\gradlew run
```

## Build and Run

```
.\gradlew clean build run
```
## Start Database in Docker
This is a option for running database locally:

```
docker run --name employee-db -e POSTGRESS_PASSWORD=password -d -p 5432:5432 postgres:alpine
```

## Flyway + Gradle
![flyway logo](https://flywaydb.org/assets/logo/flyway-logo-tm-sm.png)

[Flyway Db migration documentation](https://flywaydb.org/documentation/migrations/)

Run the following command to migrate your database:

```
gradle flywayMigrate -i
```
### PostgreSQL database
To create database:

```
CREATE DATABASE employee;
```
To create the extension to generate uuid:

```
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
```