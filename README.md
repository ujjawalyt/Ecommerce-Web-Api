# Ecommerce-Web-Api

The Ecommerce-Web-Api is a backend implementation of the Product Management System built with Spring Boot. This web-based application enables organizations to effectively manage their product inventory and sales. The API provides various endpoints to perform operations related to product management such as adding, updating, and deleting products, as well as retrieving products based on various criteria such as category, price range, and availability. Additionally, it also provides endpoints for managing user accounts, such as creating new accounts, updating account details, and logging in and out of the system. With its user-friendly interface and robust functionality, the Ecommerce-Web-Api is an essential tool for any organization looking to streamline their product management and sales processes.








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
  `Request Body`: JSON object representing the category to be added.
* `PUT /update/{adminKey}/{categoryId}` : `adminKey`: The admin key to authenticate the request
   `categoryId`: The id of the category to be updated.
`Request Body:` JSON object representing the updated category details.
* `DELETE /delete/{adminKey}/{categoryId}` : `adminKey`: The admin key to authenticate the request
`categoryId`: The id of the category to be deleted.
* `GET /getAll/{adminKey}` : `adminKey` : The admin key to authenticate the request.
* `GET /getById/{adminKey}/{categoryId}` : `adminKey`: The admin key to authenticate the request
`categoryId`: The id of the category to be retrieved.


### Category Module


* `POST /save/{categoryId}/{adminKey}` : Adds a new product to the system and associates it with the specified category.
* `DELETE /delete/{productId}/{adminKey}` : Deletes a product from the system based on its unique identifier and the admin key provided.
* `GET /{productId}` : Retrieves a product from the system based on its unique identifier.
* `GET /getAll` : Retrieves all products stored in the system.
* `GET /{productName}` : Retrieves a list of products that match the given product name.
* `PUT /update/{productId}/{adminKey}` : Updates a product's details based on its unique identifier and the admin key provided.
* `GET /getAll/sortByPrice` : Retrieves all products sorted by price in either ascending or descending order.
* `GET ResponseEntity` : Retrieves all products sorted by rating in ascending order.
* `GET /getAllByRatingDesc` : Retrieves all products sorted by rating in descending order.


### Cart Module


* `POST /add/{productId}/{userId}` :This endpoint adds a product to the cart of the specified user.
* `DELETE /delete/{productId}/{userId}` : This endpoint removes a product from the cart of the specified user.
* `PUT /update/{productId}/{userId}/{quantity}` : This endpoint increases the quantity of a product in the cart of the specified user.
* `PUT /{productId}/{userId}/{quantity}` : This endpoint decreases the quantity of a product in the cart of the specified user.
* `PUT/update/{productId}/{userId}/{quantity}` : This endpoint increases the quantity of a product in the cart of the specified user.
* `GET /getAllProduct/{userId}/{cartId}` : This endpoint retrieves a list of all products in the specified user's cart with the specified cart ID.
* `PUT /remove/{userId}` :This endpoint removes all products from the cart for the specified user.






#### For any feedback, report, suggestions, you can contact with me
### THANK YOU


