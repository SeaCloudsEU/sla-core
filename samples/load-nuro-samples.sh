curl -X POST http://localhost:8080/sla-service/providers -d@"provider-nuro.xml" -H"Content-type: application/xml" -u user:password

curl -X POST http://localhost:8080/sla-service/templates -d@"template-nuro.xml" -H"Content-type: application/xml" -u user:password

curl -X POST http://localhost:8080/sla-service/agreements -d@"agreement-nuro.xml" -H"Content-type: application/xml" -u user:password

curl -X PUT http://localhost:8080/sla-service/enforcements/$1/start -u user:password
