#CRUD PROJECT

This is the README for 

#Eva's Library Books

##Contents

1. Resources
2. Brief
3. Kanban Board
4. Data Stack
5. Front-end
6. Testing
7. Stretch Goals
8. Author

##Resources

*Presentation [located here](URL)
*Jira Board [located here](https://testjira1322.atlassian.net/jira/software/projects/ELB/boards/5/roadmap)

##Brief

To create a fully functional CRUD application encompassing a fully functional front end. The CRUD application will be biult utilising the supporting tools, methodologies, and technologies that encapsulate the concepts covered during the training.
This project will involve concepts from all core training modules, specifically

*Project Management (Kanban Board and Version COntrol)
*Databases
*JAVA
*Spring Boot
*HTML, CSS, and Javascript
*Back-end testing (J-Unit and Mockito)

##Kanban Board

The Kanban board for this project is available [here](https://testjira1322.atlassian.net/jira/software/projects/ELB/boards/5). For the Kanban board Jira Software was used, and modelled as an Agile Scrum Board. 

![Jira Board Presentation](https://imgur.com/a/yqkFUgn)

![Example of a User Story](https://imgur.com/a/10fwZOB)

##Data Stack

###Database

Two databases were used for this project - a local H2 console and a MySQL database. The H2 console was created for testing purposes - using a local database is the best way to test backend functionality as the fields do not persist in the database on refresh. The MySQL database is used for persisting data, and used to populate the front end.

###Backend

The back end is powered by Java using the Spring Boot Framework. This allows rapid and simple deployment of an integration structure between the database and the front-end. As well as the database logic, the backend has HTTP requests, and allows the front-end to access the database and work with the data there.

##Frontend

The front end is powered by HTML, CSS and Javascript, utilising the Bootstrap framework to fine tune the layout of the web page using containers, columns and rows in addition to providing a modal element for use with the update method in the application. HTML and CSS have been used to produce the look of the website and javascript has been used to get data from the DB to populate the elements on the webpage.

Screenshots of the final front end pages can be found at the following:
*[Home page](https://imgur.com/a/wGD7Vsw)
*[Add books to library](https://imgur.com/a/UxKhVye)
*[View all books, update and delete them](https://imgur.com/a/7Am5Bp4)
*[Search books by id](https://imgur.com/a/wbrKbsZ)

##Testing

Extensive backend testing was carried out, including Integration testing and Mockito testing on all CRUD functionality and methods called in JAVA. This enabled the functionalit in JAVA to be tested to make sure there are no possible breaking points in the backend.

##Stretch Goals

*Restricting data entry to prevent inaccurate records
*Alerting the user before they delete an entry to be sure they meant to
*Alerting the user when they try and search for the ID of a book that has been deleted
*Adding more search by pages so the user can search the database by title, author, or pulisher, not just ID. 

##Author and Acknowledgements

I would like to acknowledge Jordan Squared, my own gigantic brain, and the best team ever, team 1. 
