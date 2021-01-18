Texas Burger Spring Boot Application 

PreReq:

Download the project and run as Spring Boot App
Please download MongoDb in your local and Start the MongoServer
Update the application.properties for MongoDb configuration

App Structure:

Model :
contains location, menu and reservation 
Repository Layer :
contains location, menu and reservation repositories implemented using mongoRepository for storing, retrieving and searching collection of objects from a database
Service Layer: 
contains business logic for searching, storing, deleting and updating data in different collections of database
Controller Layer: 
contains location, menu, reservation RESTful web controllers which exposes different kinds of Apis on all Models

  

