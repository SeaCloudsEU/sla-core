#Appendix REST API examples#

##Providers<a name="providers"></a>##

###Create a provider###

Content type: application/xml

	$ /usr/bin/curl -u user:password -d@samples/provider-a.xml -X POST -H Content-type:application/xml -H Accept:application/xml http://localhost:8080/sla-service/providers

	POST /sla-service/providers HTTP/1.1
	Authorization: Basic dXNlcjpwYXNzd29yZA==
	User-Agent: curl/7.37.0
	Host: localhost:8080
	Content-type:application/xml
	Accept:application/xml
	Content-Length: 140
	
	<?xml version="1.0" encoding="UTF-8"?><provider>    <uuid>f4c993
	580-03fe-41eb-8a21-a56709f9370f</uuid>    <name>provider-a</name
	></provider>

	HTTP/1.1 409 Conflict
	Server: Apache-Coyote/1.1
	Content-Type: application/xml
	Content-Length: 185
	Date: Mon, 11 Aug 2014 10:30:37 GMT
	
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?><error co
	de="409" message="Provider with id:f4c993580-03fe-41eb-8a21-a567
	09f9370f already exists in the SLA Repository Database"/>
---

Provider exists.
Content type: application/xml

	$ /usr/bin/curl -u user:password -d@samples/provider-a.xml -X POST -H Content-type:application/xml -H Accept:application/xml http://localhost:8080/sla-service/providers

	POST /sla-service/providers HTTP/1.1
	Authorization: Basic dXNlcjpwYXNzd29yZA==
	User-Agent: curl/7.37.0
	Host: localhost:8080
	Content-type:application/xml
	Accept:application/xml
	Content-Length: 140
	
	<?xml version="1.0" encoding="UTF-8"?><provider>    <uuid>f4c993
	580-03fe-41eb-8a21-a56709f9370f</uuid>    <name>provider-a</name
	></provider>

	HTTP/1.1 409 Conflict
	Server: Apache-Coyote/1.1
	Content-Type: application/xml
	Content-Length: 185
	Date: Mon, 11 Aug 2014 10:30:37 GMT
	
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?><error co
	de="409" message="Provider with id:f4c993580-03fe-41eb-8a21-a567
	09f9370f already exists in the SLA Repository Database"/>
---

Provider exists.
Content type: application/xml

	$ /usr/bin/curl -u user:password -d@samples/provider-a.xml -X POST -H Content-type:application/xml -H Accept:application/json http://localhost:8080/sla-service/providers

	POST /sla-service/providers HTTP/1.1
	Authorization: Basic dXNlcjpwYXNzd29yZA==
	User-Agent: curl/7.37.0
	Host: localhost:8080
	Content-type:application/xml
	Accept:application/json
	Content-Length: 140
	
	<?xml version="1.0" encoding="UTF-8"?><provider>    <uuid>f4c993
	580-03fe-41eb-8a21-a56709f9370f</uuid>    <name>provider-a</name
	></provider>

	HTTP/1.1 409 Conflict
	Server: Apache-Coyote/1.1
	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 11 Aug 2014 10:30:37 GMT
	
	7d
	{"code":409,"message":"Provider with id:f4c993580-03fe-41eb-8a21
	-a56709f9370f already exists in the SLA Repository Database"}
	0
	
###Get all the providers###

Accept: application/xml

	$ /usr/bin/curl -u user:password -X GET -H Accept:application/xml http://localhost:8080/sla-service/providers?

	GET /sla-service/providers? HTTP/1.1
	Authorization: Basic dXNlcjpwYXNzd29yZA==
	User-Agent: curl/7.37.0
	Host: localhost:8080
	Accept:application/xml
	

	HTTP/1.1 200 OK
	Server: Apache-Coyote/1.1
	Content-Type: application/xml
	Content-Length: 172
	Date: Mon, 11 Aug 2014 10:30:37 GMT
	
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?><provider
	s><provider><uuid>f4c993580-03fe-41eb-8a21-a56709f9370f</uuid><n
	ame>provider-a</name></provider></providers>
---

Accept: application/json

	$ /usr/bin/curl -u user:password -X GET -H Accept:application/json http://localhost:8080/sla-service/providers?

	GET /sla-service/providers? HTTP/1.1
	Authorization: Basic dXNlcjpwYXNzd29yZA==
	User-Agent: curl/7.37.0
	Host: localhost:8080
	Accept:application/json
	

	HTTP/1.1 200 OK
	Server: Apache-Coyote/1.1
	Content-Type: application/json
	Transfer-Encoding: chunked
	Date: Mon, 11 Aug 2014 10:30:38 GMT
	
	46
	[{"uuid":"f4c993580-03fe-41eb-8a21-a56709f9370f","name":"provide
	r-a"}]
	0
	
