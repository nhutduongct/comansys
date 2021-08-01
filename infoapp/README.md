# Covid 19 Management System
Hệ thống quản lý dịch tễ covid 19 bao gồm các chức năng quản lý liên quan đến các ca nhiễm, nghi nhiễm covid 19, quản lý việc cách ly, tiêm vaccine phòng covid và truy vết dịch tễ qua việc tiếp xúc gần.

Các chức năng chính:
1.	Chức năng quản lý thông tin bệnh nhân
2.	Chức năng quản lý tiêm vaccine covid 19
3.	Chức năng quản lý đối tượng nhiễm, nghi nghiễm
4.	Chức năng quản lý cách ly
5.	Chức năng thể hiện đường dịch tễ

# Kiến trúc
#### Hệ thống sử dụng kiến trúc microservices, bao gồm các services
1. Consul: Discovery server, quản lý các instance của services
2. Keycloak: Authentication server (using Oauth 2.0)
#### Hệ cơ sở dữ liệu
1. Neo4j: sử dụng cho chức năng điều tra dịch tễ qua tiếp xúc gần
2. MySQL: sử dụng cho các chức năng quản lý khác
#### Resource services
1. infoapp: service cung cấp các resource liên quan đến việc quản lý bệnh nhân, vaccine, cách ly,... Kết nối và sử dụng MySQL.
2. trackerapp: service cho chức năng điều tra dịch tễ, kết nối neo4j lưu trữ những mối quan hệ tiếp xúc gần.
## Development
Dùng docker-compose để start các services cần thiết: `consul, keycloak, mysql, neo4j`
```
docker-compose -f infoapp/src/main/docker/app.yml up -d
```
Sau khi start các services trên, kiểm tra các services

Consul
```
http://<ip address>:8500
```
Keycloak
```
http://<ip address>:9080
```
MySQL port: `3306`

Neo4j
```
http://<ip address>:7474
```

Chuẩn bị dữ liệu hệ thống

Keycloak: tạo realm mới bằng cách import file 
```
infoapp/src/main/docker/keycloak/realm-config/realm-comansys-export.json
```
MySQL: import dữ liệu tỉnh thành, quận huyện, phường xã
```
city: infoapp/src/main/docker/mysql/city.csv
district: infoapp/src/main/docker/mysql/district.csv
ward: infoapp/src/main/docker/mysql/ward.csv
```

For further instructions on how to develop with JHipster, have a look at [Using JHipster in development][].

## Building for production

### Packaging as jar

To build the final jar and optimize the infoapp application for production, run:

```
./mvnw -Pprod clean verify
```

To ensure everything worked, run:

```
java -jar target/*.jar
```

Refer to [Using JHipster in production][] for more details.

### Packaging as war

To package your application as a war in order to deploy it to an application server, run:

```
./mvnw -Pprod,war clean verify
```

## Testing

To launch your application's tests, run:

```
./mvnw verify
```

For more information, refer to the [Running tests page][].

### Code quality

Sonar is used to analyse code quality. You can start a local Sonar server (accessible on http://localhost:9001) with:

```
docker-compose -f src/main/docker/sonar.yml up -d
```

Note: we have turned off authentication in [src/main/docker/sonar.yml](src/main/docker/sonar.yml) for out of the box experience while trying out SonarQube, for real use cases turn it back on.

You can run a Sonar analysis with using the [sonar-scanner](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner) or by using the maven plugin.

Then, run a Sonar analysis:

```
./mvnw -Pprod clean verify sonar:sonar
```

If you need to re-run the Sonar phase, please be sure to specify at least the `initialize` phase since Sonar properties are loaded from the sonar-project.properties file.

```
./mvnw initialize sonar:sonar
```

For more information, refer to the [Code quality page][].

## Using Docker to simplify development (optional)

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a mysql database in a docker container, run:

```
docker-compose -f src/main/docker/mysql.yml up -d
```

To stop it and remove the container, run:

```
docker-compose -f src/main/docker/mysql.yml down
```

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

```
./mvnw -Pprod verify jib:dockerBuild
```

Then run:

```
docker-compose -f src/main/docker/app.yml up -d
```

For more information refer to [Using Docker and Docker-Compose][], this page also contains information on the docker-compose sub-generator (`jhipster docker-compose`), which is able to generate docker configurations for one or several JHipster applications.

## Continuous Integration (optional)

To configure CI for your project, run the ci-cd sub-generator (`jhipster ci-cd`), this will let you generate configuration files for a number of Continuous Integration systems. Consult the [Setting up Continuous Integration][] page for more information.

[jhipster homepage and latest documentation]: https://www.jhipster.tech
[jhipster 7.1.0 archive]: https://www.jhipster.tech/documentation-archive/v7.1.0
[doing microservices with jhipster]: https://www.jhipster.tech/documentation-archive/v7.1.0/microservices-architecture/
[using jhipster in development]: https://www.jhipster.tech/documentation-archive/v7.1.0/development/
[service discovery and configuration with consul]: https://www.jhipster.tech/documentation-archive/v7.1.0/microservices-architecture/#consul
[using docker and docker-compose]: https://www.jhipster.tech/documentation-archive/v7.1.0/docker-compose
[using jhipster in production]: https://www.jhipster.tech/documentation-archive/v7.1.0/production/
[running tests page]: https://www.jhipster.tech/documentation-archive/v7.1.0/running-tests/
[code quality page]: https://www.jhipster.tech/documentation-archive/v7.1.0/code-quality/
[setting up continuous integration]: https://www.jhipster.tech/documentation-archive/v7.1.0/setting-up-ci/
