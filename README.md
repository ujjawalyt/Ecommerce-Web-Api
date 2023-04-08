# Ecommerce-Web-Api

The Product Management System is a web-based application that enables organizations to manage their product inventory and sales. This project contains the backend implementation of the Product Management System using Spring Boot.


### Technical Stacks

- Spring Boot 
- Spring Framework
- Spring Data JPA 
- MySQL 
- Hibernate
- Java
- Swagger UI
- Postman


### Modules
-  Admin Login Module
-  Users Login Module
-  Admin Module
-  Users Module
-  Category Module
-  Product Module



### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username and password as per your local database configuration
````
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/ecomdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=ujjawal
    
````
## API Root Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui.html`


### Admin Module

* `POST /save` : Adds a new admin to the system.
* `POST /login` : Allows an admin to login to the system using their username and password.`Request Body`: JSON object representing the admin's login credentials
*  `DELETE /logout/{sessionKey}` : `Path Parameters`: `sessionKey` The session key of the admin to logout
* `PUT /update/{sessionKey}`: `Path Parameters`: `sessionKey` The session key of the admin to update
`Request Body`: JSON object representing the updated admin details
* `DELETE /delete/{sessionKey}` : `Path Parameters :` `sessionKey` The session key of the admin to delete


### Users Module


* `POST /save` : Adds a new user to the system.
* `POST /login` : Allows a user to login with their username and password. `Request Body`: UserLoginDto object in JSON format
* `DELETE/logout` : Allows a user to logout from the system. `Request Header:` Authorization containing the session key
* `PUT /update` : Updates an existing user in the system.
`Request Header:` Authorization containing the session key
`Request Body:` User object in JSON format
* `DELETE /delete/{id}` : Deletes an existing user from the system
`Path Parameters:`id: The ID of the user to delete
`Request Header:` Authorization containing the session key
* `GET /Users/{id}` : Retrieves a user by their ID `Path Parameters:` id: The ID of the user to retrieve
`Request Header:` Authorization containing the session key


### Category Module


* `POST /save/{adminKey}` : The `admin key` to authenticate the request,
  `Request Body`: JSON object representing the category to be added
* `PUT /update/{adminKey}/{categoryId}` : `adminKey`: The admin key to authenticate the request
   `categoryId`: The id of the category to be updated
Request Body: JSON object representing the updated category details

* `DELETE /delete/{adminKey}/{categoryId}` : `adminKey`: The admin key to authenticate the request
`categoryId`: The id of the category to be deleted
* `GET /getAll/{adminKey}` : `adminKey` : The admin key to authenticate the request
* `GET /getById/{adminKey}/{categoryId}` : `adminKey`: The admin key to authenticate the request
`categoryId`: The id of the category to be retrieved



#### For any feedback, report, suggestions, you can contact with me
### THANK YOU


