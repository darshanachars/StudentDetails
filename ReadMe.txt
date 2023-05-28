Project Title: Student Detail Platform

Introduction:
	This is the documentation for a Student Details platform which allows users to fetch Student Details with various filters and pagination
using Spring Boot and java. It offers a range of features and funcionalities for managing Student Details in DashBoard.
	

Installation:
	This project is built on Java 17, Spring Boot 3.0.5 and Maven Build tool.
This project consists of maven dependencies such as Spring web, Spring Data JPA, mySql Database, etc. once you import the project the system will
automatically downloads the jar files. This project comes with the apache Tomcat embedded server.
	(NOTE: User name and password for the mySql database specified is root and root respectively. If the user name and password of your local database is different then it should
		be specified in application.properties file accordingly.)

Architecture:
	This platform follows a layered architecture, with the Restful API's serving as the presentation layer, the services are the buisiness logic layer
and the repositories as the data access layer. The platform uses Spring Data JPA to interact with the mySql Database.

Domain Models:
	The platform has one main domain model: Student Details
	The model represents students with properties such as Id, Name, Date of birth, Gender, Marks, Grade.
	

API Documentation:
	The platform exposes several REST'ful API's that allow users to perform various operations.
These include:

	(NOTE:- All the following API's contans pagination, specifying the page details is optional. If you dont specify Parameters such as pageSize and pageNo in the URI,
		then it will take default value as pageSize=5 and pageNo=0)


	I.	GET	/StudentDetails/findAll : This URI fetches all the Student Details present in the Database.
						 Example:- http://localhost:8080/studentDetails/findAll?pageSize=3&pageNo=0

	II.	GET	/StudentDetails/filterByMarks : This URI fetches the Student Details with Marks filter from the Database.
						        This URI should be accessed with compulory minMarks and maxMarks parameters and optional page size &no parameters.
							Example:- http://localhost:8080/studentDetails/filterByMarks?minMarks=300&maxMarks=400
	
	III.	GET	/StudentDetails/filterByGender : This URI fetches all the Student Details with Gender filter.
							This URI should be accessed with one or more gender parameters and optional page size& no parameters.
							Example:- ttp://localhost:8080/studentDetails/filterByGender?gender1=male
								  http://localhost:8080/studentDetails/filterByGender?gender1=female&gender2=others

	IV.	GET 	/StudentDetails/filterByBirthYear : This URI fetches all the Student Details with Birth Year filter.
							   This URI should be accessed with compulsory year parameter and optional page size & no parameters.
							   Example:- Example:- http://localhost:8080/studentDetails/filterByBirthYear?year=2009

	V.	GET	/StudentDetails/filterByGrade : This URI fetches all the Student Details with Grade filter.
							This URI should be accessed with at least one grade and optional page size& no parameters.
							Example:- http://localhost:8080/studentDetails/filterByGrade?grade1=A&grade2=C		
								  http://localhost:8080/studentDetails/filterByGrade?grade1=B		      



conclusion:
	This Student Details platform provides a range of features and functionalities for Displaying Student Details. It is built using SpringBoot 
and java. And it uses a layered architecture to ensure seperation of concerns and maintability. The platform also includes proper pagination, filters 
proper API usage and integrity.












