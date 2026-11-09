# Introduction

A minimal task-tracking REST API built with Spring Boot + raw JDBC.

# Pre-requisites

1. PostgreSQL (or any configured DB)
2. JDK 25
3. Maven
4. Docker (not a compulsion as of now)

# How to run

1. Update application.properties with your username or password, OR
2. Create env var PG_UNAME and PG_PASSWD with your db username and password respectively.
3. Create a db called phase0 in your database cluster or update datasource url in application.properties.
4. To run: mvn spring-boot run

# Sample outputs

1.
curl -i -X POST http://localhost:8080/tasks \
-H "Content-type: application/json" \
-d '{"title": "test task2"}' \
HTTP/1.1 201 \
Content-Type: application/json\
Transfer-Encoding: chunked \
Date: Sun, 08 Nov 2026 14:40:26 GMT

{"id":2,"title":"test task2","done":false,"createdAt":"2026-11-08T14:40:26.697112Z"}

2.
curl -i http://localhost:8080/tasks \
HTTP/1.1 200 \
Content-Type: application/json\
Content-Length: 171\
Date: Sun, 08 Nov 2026 14:40:36 GMT

[{"id":1,"title":"test task1","done":false,"createdAt":"2026-11-08T08:52:05.525804Z"},{"id":2,"title":"test task2","done":false,"createdAt":"2026-11-08T14:40:26.697112Z"}]

3.
curl -i -X POST http://localhost:8080/tasks -H "Content-type: application/json" -d '{"title": ""}'\
HTTP/1.1 400\
Content-Type: application/json\
Transfer-Encoding: chunked\
Date: Sun, 08 Nov 2026 14:43:16 GMT\
Connection: close

{"Error":"title can't be null, empty string or string of whitespaces"}