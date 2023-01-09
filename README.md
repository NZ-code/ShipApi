# REST API

## Description
 ShipAndCrew api provide a set of RESTful endpoints for 
 CRUD operations.
 The Project is divided into 3 separate projects 
 (two stand-alone applications and  Spring Cloud Gateway).
 Business classes connected with 1:N relationship. 

## Get list of ships

### Request

`GET http://localhost:8080/api/ships/`

### Response
    HTTP/1.1 200 OK
    content-type: application/json
    date: Fri, 09 Dec 2022 13:42:41 GMT
    transfer-encoding: chunked
    
    {"ships":[{"id":1,"name":"HMS Erebus","length":32.0},{"id":2,"name":"HMS Terror","length":31.09}]}

## Create a new ship

### Request

`POST http://localhost:8080/api/ships/`
` JSON
    {
    "name":"HMS Erebus",
    "length" : 32
    }
`
### Response
    HTTP/1.1 201 Created
    content-length: 0
    date: Fri, 09 Dec 2022 13:43:42 GMT
    location: http://localhost:8081/api/ships/3

## Get a specific ship

### Request

`GET http://localhost:8080/api/ships/1`

### Response
    HTTP/1.1 200 OK
    content-type: application/json
    date: Fri, 09 Dec 2022 13:45:52 GMT
    transfer-encoding: chunked
    {"id":1,"name":"HMS Erebus","length":32.0}
    

## Change a ship

### Request

`PUT http://localhost:8080/api/ships/1`
` JSON
    {
	"name":"HMS Victory",
  	"length": 57.0
    }
`
### Response
    HTTP/1.1 202 Accepted
    content-length: 0
    date: Fri, 09 Dec 2022 13:48:16 GMT

### Request

`DELETE http://localhost:8080/api/ships/1`

### Response
    HTTP/1.1 202 Accepted
    content-length: 0
    date: Fri, 09 Dec 2022 14:02:21 GMT
    


## Get list of crew members

### Request

`GET http://localhost:8080/api/ships/1/humans`

### Response
    HTTP/1.1 200 OK
    content-type: application/json
    date: Fri, 09 Dec 2022 13:55:42 GMT
    transfer-encoding: chunked
    
    {"humans":[{"id":1,"name":"Sir John Franklin","age":59},{"id":2,"name":"James Fitzjames","age":31}]}

## Create a new crew member

### Request

`POST http://localhost:8080/api/ships/1/humans`
` JSON
    {
	"name": "Sir John Franklin",
  	"age" : 59
    }
`
### Response
    HTTP/1.1 202 Accepted
    content-length: 0
    date: Fri, 09 Dec 2022 13:54:17 GMT

## Get a specific crew member

### Request

`GET http://localhost:8080/api/ships/1/humans/1`

### Response
    HTTP/1.1 200 OK
    content-type: application/json
    date: Fri, 09 Dec 2022 13:58:08 GMT
    transfer-encoding: chunked
    
    {"id":1,"name":"Sir John Franklin","age":59}
    

## Change a crew member

### Request

`PUT http://localhost:8080/api/ships/1/humans`
` JSON
    {
	"name": "James Walter Fairholme",
  	"age" : 24
    }
`
### Response
    HTTP/1.1 202 Accepted
    content-length: 0
    date: Fri, 09 Dec 2022 13:59:45 GMT
    
## Delete a crew member

### Request

`DELETE http://localhost:8080/api/ships/1/humans/1`

### Response
    HTTP/1.1 202 Accepted
    content-length: 0
    date: Fri, 09 Dec 2022 14:01:01 GMT
    

    



    


