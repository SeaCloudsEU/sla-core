# SeaClouds SLA Core #

##Description##

The SLA Core is an implementation of an SLA module, compliant with WS-Agreement.

It supports:

* one-shot negotiation
* agreement enforcement
* REST API

Read the [documentation][1]

##Technical description##

Read the [Developer Guide][2]

##How to deploy##

Read the [Installation Guide][3]

##Nuro example##

The SLA Core has been tested with a running brooklyn which has deployed Nuro's Sensor.

The steps are:

1. Deploy [Brooklyn][4]
1. Deploy Nuro Sensor. The following yaml file was used: [Nuro Sensor Blueprint][5]
1. Run Sla Core. For example: `$ BROOKLYN_URL=http://localhost:8082 bin/runserver`
1. Load agreement. `$ bin/load-nuro-samples.sh <app-id> <apache-entity-id>`, where app-id and apache-entity-id are 
   the brooklyn ids of the application and apache server, respectively.

##License##

Licensed under the [Apache License, Version 2.0][8]

[1]: doc/TOC.md
[2]: doc/developer-guide.md
[3]: doc/installation-guide.md
[4]: https://github.com/SeaCloudsEU/incubator-brooklyn
[5]: samples/nuro-v1.1.yaml
[8]: http://www.apache.org/licenses/LICENSE-2.0
