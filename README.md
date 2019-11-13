.\gradlew build docker
docker-compose up

Incase you need to setup couchbase first. Then run this.
docker run -d --name db -p 8091-8094:8091-8094 -p 11210:11210 couchbase

need to add script to run setup calls:
http://www.madhur.co.in/blog/2016/07/07/create-couchbase-bucket-docker.html
https://forums.couchbase.com/t/how-to-create-preconfigured-couchbase-docker-image-with-data/17004


Current setup....
docker run -d --name db -p 8091-8094:8091-8094 -p 11210:11210 couchbase

- cluster name: sw-doc-data
- Admin user name: Adminsitrator
- admin password: couchbase
- data: 256
- index: 256
- search: 256
- eventing: 256
- analytics: 1056

create bucket
- test (no replica needed)

Create user
- username: test
- password: couchbase
... roles
- Views (BOTH)
- Query and Index Services (ALL)

URL for wait-for-it container script
https://github.com/vishnubob/wait-for-it
https://github.com/jwilder/dockerize  ---USE THIS FIRST

