(Work in Progress)

## Intro

The intention of this repo is to provide an example of CI/CD (excluding node provisioning), using the following tools:
* Ansible
* A CentOS Docker container as Ansible host (even though it's not a good practice for production)
* Docker-compose to bookstrap the environment, including:
1. Bitbucket
1. Jenkins
1. Nexus
1. MySQL
* Liquibase
* Jenkins files to describe the CI/CD pipeline
* Maven

To carry on the example, I will use a Java-based RESTful API service.
The example includes Liquibase changesets.

## Config Management with Ansible

* Setup the host
* Download artifacts from Nexus using maven_artifact module
* Run Liquibase changesets
* Run the API as a Linux service
