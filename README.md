
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

## Prerequisites

* [Git](https://git-scm.com/downloads)
* [Java 1.8](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html) select JDK for your platform
* IDE ([VSCode](https://code.visualstudio.com/download), [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows), [Eclipse](https://www.eclipse.org/downloads/))
* Latest version [Gradle] (https://gradle.org/releases/)
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

## Flyway + Gradle
![flyway logo](https://flywaydb.org/assets/logo/flyway-logo-tm-sm.png)

[Flyway Db migration documentation](https://flywaydb.org/documentation/migrations/)

Run the following command to migrate your database:

```
gradle flywayMigrate -i
```
### Creating a network to execution containers
```
docker network create --driver bridge postgres-network
docker network ls
```

### Creating a container to execute a instance of PostgreSQL
```
docker run --name teste-postgres --network=postgres-network -e "POSTGRES_PASSWORD=Postgres2018!" -p 5432:5432 -v /home/Desenvolvimento/PostgreSQL:/var/lib/postgresql/data -d postgres
```

### Creating a container for execution of pgAdmin 4
```
docker run --name teste-pgadmin --network=postgres-network -p 15432:80 -e "PGADMIN_DEFAULT_EMAIL=email@email.com.br" -e "PGADMIN_DEFAULT_PASSWORD=PgAdmin2018!" -d dpage/pgadmin4
```
### Managing user on PostgreSQL
For password less login:

```
sudo -u user_name psql db_name
```
To reset the password if you have forgotten:

```
ALTER USER user_name WITH PASSWORD 'new_password';
```
To create a new user:

```
CREATE USER user_name WITH PASSWORD 'new_password';
```