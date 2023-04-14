# MS - Backend!!

This solution was resolved using
"Postgres", "MongoDb", "activeMq/artemis"

### Reference Documentation
 
* Integrated with ms-integration through activeMq artemis

### Running the project

- Requisites
  - docker
  - postman
  - Ports required for the project
    - 8080 for Second Microservice (ms-backend)
    - 8081 for First Microservice (ms-integration)
    - 5432 for postgres
    - 27017 for mongoDb
    - 5672, 61616, 8161 for activeMq Artemis

- run into the terminal 
  docker-compose up

- import the file "coinmarketCollection.postman_collection.json" to your postman
  - a folder called "coinmarketCollection" should appear
  - now you should be able to execute the POST rest service
  - and after that you can execute the GET rest service
