# TEST
## Spring Boot-Hibernate-H2-Rest API example
---  
Run the application on your IDE and check the links

- Documentation
```sh
./doc/index.html
```
- APIs information
```sh
http://localhost:8080/v2/api-docs
```
- Swagger
```sh
http://localhost:8080/swagger-ui
```
- Remote access to in-memory H2 database
```sh
jdbc:h2:tcp://localhost:9092/mem:dbname
```
- APIs
```sh
saveIncident
getAllIncidents
getLatestIncident
saveTask
getAllTasksByIncident
getUncompletedTasksByIncident
getExpiredTasksByIncident
```
## API Example
```sh
http://localhost:8080/saveIncident
```
- Insert
```sh
{
    "name":"First incident",
    "createdTime": "14634567890",
}
```
- Update
```sh
{
    "id": "8a8080b87c22bfd5017c22bfe9420000"
    "name":"First incident changed",
    "createdTime": "14634567890",
}
```  
---  
#### Mahdi Rouzbahaneh

