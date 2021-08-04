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
