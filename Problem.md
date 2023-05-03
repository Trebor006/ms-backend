**Test task for Java back-end developer**

# Summary
Create a microservice-based solution for getting and stoting convertions data from https://coinmarketcap.com/converter/ .

# Realization
Solution must contain two Java-Spring mecro-services, connected each-other with ActiveMQ. Also it should store the convertions hystorical data inside the DB, connected to the solution with a Hibernate, and it should contain Rest-full interface.

## First microservice containment
1. Must contain intgration service for https://coinmarketcap.com/converter/
2. Must contain Hibernate database storing service
3. Must contain consumer and producer to connect second microservice

## Second microservice containment
1. Must contain rest-controller for convertions requesting
2. Must contain consumer and producer to connect first microservice
3. *** Could contain hashing logic to store AMQ requests from the first microservice


---


---
- Allowed to use inmemmory databases to store response hashes between the microservices
- Projects should use git
- Project should be mavens or gradle
- It will be good to use docker and every CI-configuring tools as compose, ... or kubernetes
- It will be good to implement Unit-tests
- It will be good to use DB-migrations tools such as liquibase, flyway, etc.
