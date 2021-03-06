# Welcome to Purple Cow Test Project
Built by someone who has never used Spring or Docker before so 
this is going to be be a learning experience 

This will launch a simple REST API that will load some default items and be available for 
actions. This uses [Spring Boot](https://spring.io).

To run locally: 
` ./mvnw clean spring-boot:run`

By default the service will run on `http://localhost:3000/items`. If you wish to 
change the default port, edit the server.port in application.properties found in src/main/resources

Supported actions:
- `GET  /items` : gets all items from list
- `GET  /items/{id}` : gets one item of the specified ID (if it exists)
- `POST /items` : posts new list of items (deletes existing)
- `PUT  /items` : adds one new item to the list
- `PUT  /items/{id}` : updates existing item if it finds one, otherwise adds it
- `DELETE /items` : clears all items in the list
- `DELETE /items/{id}` : deletes single item

The format for a single item is:
`{"name" : "example"}`
For multiple items, it is:
`{"items" = [{"name" : "example 1"}, ... , {"name" : "example n"}]}`

Todos:
- Need to create a database
- Dockerfile testing 
- Docker should have persistent memory
- check post behavior - does client really want to delete existing data?
- actually write test class logic

The Item class doesn't do anything, so work with client to figure out what features to add
