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
-  Cart Module
-  Orders Module
-  ProductBill Module


### Features

* Admin Login Features :-
    This module provides the functionality for admin authentication and validation to access the admin dashboard. The following features are included:
    
    * Admins can log in with their username and password.
    * The module validates the admin's credentials and generates a session token for the admin to access the admin dashboard.
    * The session token is stored securely and used to verify the admin's identity for subsequent requests.
* Users Login Features :-
  This module provides the functionality for user authentication and validation to access user-specific features. The following features are included:

  * Users can register and create an account with a username and password.
  * Users can log in with their username and password.
  * The module validates the user's credentials and generates a session token for the user to access user-specific features.
  * The session token is stored securely and used to verify the user's identity for subsequent requests.    
* Admin Features :-
    This module provides the functionality for admins to manage the application. The following features are included:

  *  Admins can view and manage users and their information.
  *  Admins can view and manage products and their information.
  *  Admins can view and manage orders and their information.
  *  Admins can view and manage product bills and their information.
* Users Features :-
  This module provides the functionality for users to manage their accounts and access user-specific features. The following features are included:

  *  Users can view and update their profile information.
  *  Users can view their order history.
  *  Users can view and manage their cart.
* Category Features :-
 This module provides the functionality for admins to manage product categories. The following features are included:

  * Admins can view and manage categories.
  * Admins can add new categories.
* Product Features :-
   This module provides the functionality for admins to manage products. The following features are included:

  *  Admins can view and manage products.
  *  Admins can add new products.
  *  Users can view product details and add products to their cart.
* Cart Features :-
 This module provides the functionality for users to manage their carts. The following features are included:

  *  Users can view and manage their cart.
  *  Users can add and remove products from their cart.
* Orders Features:-
 This module provides the functionality for admins to manage orders. The following features are included:

  *  Admins can view and manage orders.
  *  Users can view their order history and order details.
* ProductBill Features:-
 This module provides the functionality for admins to generate bills for orders. The following features are included:

  *  Admins can view and manage product bills.
  *  Product bills are generated automatically for orders.

### ER Diagram
The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
![Screenshot 2023-04-13 094235](https://user-images.githubusercontent.com/87421981/231651857-c4916b59-7376-4776-ab80-d40046619e0e.png)

### Project Structure
![Screenshot 2023-04-13 095658](https://user-images.githubusercontent.com/87421981/231653589-1ae1eec9-7a4c-4725-a2d7-a7ce5f047f06.png)



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


## Orders Module


* `POST /{userId}/{cartId}` : Creates a new order from the specified cart.`Request Body`: JSON representation of the Orders object containing information about the new order.
* `GET /{userId}/{orderId}` : Retrieves the details of the specified order.`Returns:` The Orders object containing the details of the specified order.
* `DELETE /{orderId}/{userId}` : Deletes the specified order from the system.`Returns:` The Orders object representing the deleted order.
* `PUT /{orderId}/{status}` : Updates the status of the specified order.`Returns:` The updated Orders object with the status updated.


##  ProductBill Module


* `POST /{orderId}/{userId}`:Adds the billing information for a given order and calculates the total amount payable for the user.`Returns` a ProductBill object with the updated total amount
* `GET /{billId}/{userId}` : Retrieves the billing information for a given bill ID and user ID. `Returns` a ProductBill object containing the billing information.


### some screenshots of the Swagger UI 

![ujjawal](https://user-images.githubusercontent.com/87421981/231655752-434e114f-d9bb-4cd4-8c62-4fb405cb77be.PNG)

![Screenshot 2023-04-13 100409](https://user-images.githubusercontent.com/87421981/231655114-562f5bf3-f3cd-46cc-9693-5cf74191135b.png)
![Screenshot 2023-04-13 100529](https://user-images.githubusercontent.com/87421981/231655120-00a82767-187c-4dc1-9f78-7ed64c98c408.png)

![Screenshot 2023-04-13 100602](https://user-images.githubusercontent.com/87421981/231655292-3686417e-6a8a-4224-9f5f-b186bd35786f.png)

![screenshort1](https://user-images.githubusercontent.com/87421981/231656006-59a9b324-ad68-4367-a04f-7ceb2ad22d90.PNG)


#### For any feedback, report, suggestions, you can contact with me
### THANK YOU


