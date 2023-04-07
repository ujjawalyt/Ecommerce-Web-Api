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
-  Login Module
-	 Admin Module
-	 Users Module



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

* `POST /add` : Register a new admin with proper data validation and admin session
* `POST /login` : Admin can login with username  and password provided at the time of registation
* `DELETE/logout` : Admin can logout from session key
* `PUT /update/{key}` : Updates admin details
* `DELETE /delete/{key}` : Deletes the admin with passed key


### Users Module


* `POST /save` : Adding new users
* `POST /login` : Users can login with username  and password provided at the time of registation
*  `DELETE/logout` : Users can logout from session key
* `PUT /update` : Updates Users details 
* `DELETE /delete/{id}` : Deletes logged in user on the basis of id
* `GET /Users/{id}` : Getting Users on the basis of id


#### For any feedback, report, suggestions, you can contact with me
### THANK YOU


