This is Texas Burger Spring Boot Application 

Please download the project and run as Spring Boot App

Please download MongoDb and Start the MongoServer

Update the application.properties for MongoDb configuration

Admin application contains 

Model (package com.example.HamburgerAdminPanel.Entity): contains location, menu and reservation entities, used to define how every collection(data) is structured.
Repository (package com.example.HamburgerAdminPanel.Repository): contains location, menu and reservation repositories used to encapsulate the mechanism of storing, retrieving and searching collection of objects from a database(mongoDB).
Service Layer (package com.example.HamburgerAdminPanel.Service): contains logic for searching, storing, deleting and updating data in different collections(menu, location, reservation).
Controller Layer (package com.example.HamburgerAdminPanel.Controller): Application has location, menu, reservation RESTful web controller which maps the different HTTP requests to service methods.
  

