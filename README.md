# Introduction

A minimal task-tracking REST API built with Spring Boot + raw JDBC.

# Prerequisites

1. PostgreSQL (or any configured DB)
2. JDK 25
3. Maven
4. Docker (not a compulsion as of now)

# How to run

1. Create env var PG_UNAME and PG_PASSWD with your db username and password respectively.
2. DB user whose username and password you are providing must have DB creation ability.
3. Create a db called phase0 in your database cluster or update datasource url in application.properties.
4. To run: mvn spring-boot:run

NOTE: The tasks table is created automatically on startup by schema.sql

# Sample outputs

1. 
curl -i http://localhost:8080/tasks

HTTP/1.1 200
Content-Type: application/json
Content-Length: 171
Date: Mon, 09 Nov 2026 15:41:17 GMT

[{"id":1,"title":"test task1","done":false,"createdAt":"2026-11-08T08:52:05.525804Z"},{"id":2,"title":"test task2","done":false,"createdAt":"2026-11-08T14:40:26.697112Z"}]

2.
curl -i -X POST http://localhost:8080/tasks -H "Content-type: application/json" -d '{"title": null}'

HTTP/1.1 400
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 09 Nov 2026 15:41:53 GMT
Connection: close

{"error":"title can't be null, empty string or string of whitespaces"}

3.
curl -i -X POST http://localhost:8080/tasks -H "Content-type: application/json" -d '{"title": "test task3"}'

HTTP/1.1 201
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 09 Nov 2026 15:44:35 GMT

{"id":3,"title":"test task3","done":false,"createdAt":"2026-11-09T15:44:35.648Z"}