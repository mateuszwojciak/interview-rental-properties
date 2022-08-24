# PROPERTY RENTAL APPLICATION

## Tools

`Java 8`
`Maven`
`Spring & Spring Boot`
`H2 Database`
`Lombok`
`Gson, from: https://mvnrepository.com`
`Mockito`
`JUnit`
`IntelliJ IDEA`
`Compilation scripts: mvnw & mvnw.cmd`
`Postman for additional testing purposes`

## Unit testing

In `src/test/java/com/klg/interview` there are tests for controller and service layers ONLY for update of Reservation.

## Relational databases

In file `data.sql` in resources there are initial values of databases (TENANTS, LANDLORDS, PROPERTIES and RESERVATIONS) which are loaded during the start of application.

Structure of relational databases (entities and tables) are also generated during the start by Spring based on Annotations in classes in domain package (classes: TENANT, LANDLORD, PROPERTY, RESERVATION).

## Endpoints with examples

## GET

### Request GET all Landlords

`GET /landlord/getLandlords`

    curl --location --request GET 'http://localhost:8080/v1/landlord/getLandlords'

### Response

[{"id":1,"name":"Wynajmujacy1"},{"id":2,"name":"Wynajmujacy2"},{"id":3,"name":"Wynajmujacy3"}]

### Request GET Landlord with Id

`GET /landlord/getLandlord`

    curl --location --request GET 'http://localhost:8080/v1/landlord/getLandlord?landlordId=2'

### Response

{"id":2,"name":"Wynajmujacy2"}

### Request GET all Tenants

`GET /tenant/getTenants`

    curl --location --request GET 'http://localhost:8080/v1/tenant/getTenants'

### Response

[{"id":1,"name":"Najemca1"},{"id":2,"name":"Najemca2"},{"id":3,"name":"Najemca3"},{"id":4,"name":"Najemca4"},{"id":5,"name":"Najemca5"},{"id":6,"name":"Najemca6"},{"id":7,"name":"Najemca7"},{"id":8,"name":"Najemca8"}]

### Request GET Tenants with Id

`GET /tenant/getTenant`

    curl --location --request GET 'http://localhost:8080/v1/tenant/getTenant?tenantId=4'

### Response

{"id":4,"name":"Najemca4"}

### Request GET Tenant (search by tenant name)

`GET /tenant/getByTenantName`

    curl --location --request GET 'http://localhost:8080/v1/tenant/getByTenantName?name=Najemca3'

### Response

{"id":3,"name":"Najemca3"}

### Request GET all Properties

`GET /property/getProperties`

    curl --location --request GET 'http://localhost:8080/v1/property/getProperties'

### Response

[{"id":1,"name":"Obiekt1","price":5000.00,"rentArea":72,"description":"Mieszkanie"},{"id":2,"name":"Obiekt2","price":5000.00,"rentArea":65,"description":"Lokal"},{"id":3,"name":"Obiekt3","price":4000.00,"rentArea":42,"description":"Mieszkanie"},{"id":4,"name":"Obiekt4","price":8500.00,"rentArea":120,"description":"Lokal"},{"id":5,"name":"Obiekt5","price":9000.00,"rentArea":130,"description":"Mieszkanie"},{"id":6,"name":"Obiekt6","price":3500.00,"rentArea":35,"description":"Lokal"}]

### Request GET Property with Id

`GET /property/getProperty`

    curl --location --request GET 'http://localhost:8080/v1/property/getProperty?propertyId=3'

### Response

{"id":3,"name":"Obiekt3","price":4000.00,"rentArea":42,"description":"Mieszkanie"}

### Request GET Property (search by property name)

`GET /property/getByPropertyName`

    curl --location --request GET 'http://localhost:8080/v1/property/getByPropertyName?name=Obiekt3'

### Response

{"id":3,"name":"Obiekt3","price":4000.00,"rentArea":42,"description":"Mieszkanie"}

### Request GET all Reservations

`GET /reservation/getReservations`

    curl --location --request GET 'http://localhost:8080/v1/reservation/getReservations'

### Response

[{"id":1,"tenant":{"id":1,"name":"Najemca1"},"id_tenant":null,"landlord":{"id":1,"name":"Wynajmujacy1"},"id_landlord":null,"property":{"id":2,"name":"Obiekt2","price":5000.00,"rentArea":65,"description":"Lokal"},"id_property":null,"rentalPeriodStart":"2022-07-01","rentalPeriodEnd":"2022-08-31","price":5000.00},{"id":2,"tenant":{"id":2,"name":"Najemca2"},"id_tenant":null,"landlord":{"id":2,"name":"Wynajmujacy2"},"id_landlord":null,"property":{"id":3,"name":"Obiekt3","price":4000.00,"rentArea":42,"description":"Mieszkanie"},"id_property":null,"rentalPeriodStart":"2022-08-01","rentalPeriodEnd":"2022-09-30","price":4000.00},{"id":3,"tenant":{"id":3,"name":"Najemca3"},"id_tenant":null,"landlord":{"id":3,"name":"Wynajmujacy3"},"id_landlord":null,"property":{"id":1,"name":"Obiekt1","price":5000.00,"rentArea":72,"description":"Mieszkanie"},"id_property":null,"rentalPeriodStart":"2022-02-01","rentalPeriodEnd":"2022-10-31","price":5000.00},{"id":4,"tenant":{"id":3,"name":"Najemca3"},"id_tenant":null,"landlord":{"id":3,"name":"Wynajmujacy3"},"id_landlord":null,"property":{"id":4,"name":"Obiekt4","price":8500.00,"rentArea":120,"description":"Lokal"},"id_property":null,"rentalPeriodStart":"2024-01-01","rentalPeriodEnd":"2024-03-31","price":8500.00},{"id":5,"tenant":{"id":5,"name":"Najemca5"},"id_tenant":null,"landlord":{"id":1,"name":"Wynajmujacy1"},"id_landlord":null,"property":{"id":5,"name":"Obiekt5","price":9000.00,"rentArea":130,"description":"Mieszkanie"},"id_property":null,"rentalPeriodStart":"2022-07-01","rentalPeriodEnd":"2022-08-31","price":9000.00}]

### Request GET Reservation with Id

`GET /reservation/getReservation`

    curl --location --request GET 'http://localhost:8080/v1/reservation/getReservation?reservationId=2'

### Response

{"id":2,"tenant":{"id":2,"name":"Najemca2"},"id_tenant":null,"landlord":{"id":2,"name":"Wynajmujacy2"},"id_landlord":null,"property":{"id":3,"name":"Obiekt3","price":4000.00,"rentArea":42,"description":"Mieszkanie"},"id_property":null,"rentalPeriodStart":"2022-08-01","rentalPeriodEnd":"2022-09-30","price":4000.00}

### Request GET Reservation (search by tenant name)

`GET /reservation/searchByTenant`

    curl --location --request GET 'http://localhost:8080/v1/reservation/searchByTenant?tenantName=Najemca3' \
    --data-raw ''

### Response

[{"id":3,"tenant":{"id":3,"name":"Najemca3"},"id_tenant":null,"landlord":{"id":3,"name":"Wynajmujacy3"},"id_landlord":null,"property":{"id":1,"name":"Obiekt1","price":5000.00,"rentArea":72,"description":"Mieszkanie"},"id_property":null,"rentalPeriodStart":"2022-02-01","rentalPeriodEnd":"2022-10-31","price":5000.00},{"id":4,"tenant":{"id":3,"name":"Najemca3"},"id_tenant":null,"landlord":{"id":3,"name":"Wynajmujacy3"},"id_landlord":null,"property":{"id":4,"name":"Obiekt4","price":8500.00,"rentArea":120,"description":"Lokal"},"id_property":null,"rentalPeriodStart":"2024-01-01","rentalPeriodEnd":"2024-03-31","price":8500.00}]

### Request GET Reservation (search by property name)

`GET /reservation/searchByProperty`

    curl --location --request GET 'http://localhost:8080/v1/reservation/searchByProperty?propertyName=Obiekt5' \
    --data-raw ''

### Response

[{"id":5,"tenant":{"id":5,"name":"Najemca5"},"id_tenant":null,"landlord":{"id":1,"name":"Wynajmujacy1"},"id_landlord":null,"property":{"id":5,"name":"Obiekt5","price":9000.00,"rentArea":130,"description":"Mieszkanie"},"id_property":null,"rentalPeriodStart":"2022-07-01","rentalPeriodEnd":"2022-08-31","price":9000.00}]

## POST

### Request POST Tenant

`POST /tenant/createTenant`

    curl --location --request POST 'http://localhost:8080/v1/tenant/createTenant' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 9,
        "name": "Najemca9"
    }'

### Response

No response body.

### Request POST Landlord

`POST /landlord/createLandlord`

    curl --location --request POST 'http://localhost:8080/v1/landlord/createLandlord' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 4,
        "name": "Wynajmujacy4"
    }'

### Response 

No response body.

### Request POST Property

`POST /property/createProperty`

    curl --location --request POST 'http://localhost:8080/v1/property/createProperty' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 7,
        "name": "Obiekt7",
        "price": 2000.00,
        "rentArea": 30.00,
        "description": "Mieszkanie"
    }'

### Response

No response body.

### Request POST Reservation (based on above POST requests)

`POST /reservation/createReservation`

    curl --location --request POST 'http://localhost:8080/v1/reservation/createReservation' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 6,
        "id_tenant": 9,
        "id_landlord": 4,
        "id_property": 7,
        "rentalPeriodStart": "2022-09-01",
        "rentalPeriodEnd": "2023-03-31",
        "price": 2000.00
    }'

### Response

No response body.

### Request POST Reservation (reservation in particular dates already exists)

`POST /reservation/createReservation`

    curl --location --request POST 'http://localhost:8080/v1/reservation/createReservation' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 6,
        "id_tenant": 1,
        "id_landlord": 1,
        "id_property": 1,
        "rentalPeriodStart": "2022-08-01",
        "rentalPeriodEnd": "2023-03-31",
        "price": 2000.00
    }'

### Response

{"status":422,"error":"Unprocessable Entity","message":"Nie można zarezerwować tego obiektu, bo obiekt jest w tym czasie wynajmowany","path":"/v1/reservation/createReservation"}

## PUT

### Request PUT Tenant

`PUT /tenant/updateTenant`

    curl --location --request PUT 'http://localhost:8080/v1/tenant/updateTenant' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 1,
        "name": "Mark"
    }'

### Response

{"id":1,"name":"Mark"}

### Request PUT Landlord

`PUT /landlord/updateLandlord`

    curl --location --request PUT 'http://localhost:8080/v1/landlord/updateLandlord' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 1,
        "name": "John"
    }'

### Response

{"id":1,"name":"John"}

### Request PUT Property

`PUT /property/updateProperty`

    curl --location --request PUT 'http://localhost:8080/v1/property/updateProperty' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 1,
        "name": "Warszawa",
        "price": 2000.00,
        "rentArea": 30.00,
        "description": "Mieszkanie"
    }'

### Response

{"id":1,"name":"Warszawa","price":2000.00,"rentArea":30,"description":"Mieszkanie"}

### Request PUT Reservation

`PUT /reservation/updateReservation`

    curl --location --request PUT 'http://localhost:8080/v1/reservation/updateReservation' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 4,
        "id_tenant": 3,
        "id_landlord": 3,
        "id_property": 4,
        "rentalPeriodStart": "2023-01-01",
        "rentalPeriodEnd": "2023-04-30",
        "price": 8500.00
    }'

### Response

{"id":4,"tenant":{"id":3,"name":"Najemca3"},"id_tenant":null,"landlord":{"id":3,"name":"Wynajmujacy3"},"id_landlord":null,"property":{"id":4,"name":"Obiekt4","price":8500.00,"rentArea":120,"description":"Lokal"},"id_property":null,"rentalPeriodStart":"2023-01-01","rentalPeriodEnd":"2023-04-30","price":8500.00}



