Project Title: Insurance Management platform

Introduction:
	This is the documentation for an insurance management platform which allows users to manage insurance policies, clients and claims
using Spring Boot and java. It offers a range of features and funcionalities for managing insurance related information.
	

Installation:
	This project is built on Java 17, Spring Boot 3.0.5 and Maven Build tool.
This project consists of maven dependencies such as Spring web, Spring Data JPA, H2 Database, etc. once you import the project the system will
automatically downloads the jar files. This project comes with the apache Tomcat embedded server.
	(NOTE: User name for H2 database= sa. And password=password)

Architecture:
	This platform follows a layered architecture, with the Restful API's serving as the presentation layer, the services are the buisiness logic layer
and the repositories as the data access layer. This project also features Data Transfer Layer(DTO-layer) which is used here to facilitate communication between
API's and server without esposing the sensitive information from the original resource. The platform uses Spring Data JPA to interact with the embedded database H2.

Domain Models:
	The platform has three main domain models: Client, Insurance Policy and Claim
	The Client model represents a client with properties such as name, date of birth, address and contact information.
	The Insurance Policy Model represents an insurance policy with properties like policy number, type, coverage amount, premium, start date and end date.
	The Claim model represents an insurance policy claim with properties like claim number, description, claim date and claim status.
Each claim is associated with an insurance policy and each policy is associated with a client.

API Documentation:
	The platform exposes several REST'ful API's that allow users to perform various operations.
These include:
	i. 	GET /api/clients: Retrieves a list of all clients.
	ii. 	GET /api/clients/{id}: Retrieves a client by ID.
	iii. 	POST /api/clients: Creates a new client.
	iv. 	PUT /api/clients/{id}: Updates a client's information by ID.
	v. 	DELETE /api/clients/{id}: Deletes a client by ID.

	vi. 	GET /api/policies: Retrieves a list of all insurance policies.
	vii. 	GET /api/policies/{id}: Retrieves a specific insurance policy by ID.
	viii. 	POST /api/policies: Creates a new insurance policy.
	ix. 	PUT /api/policies/{id}: Updates an insurance policy.
	x.	 DELETE /api/policies/{id}: Deletes an insurance policy.

	xi. 	GET /api/claims: Fetch all claims.
	xii. 	GET /api/claims/{id}: Fetch a specific claim by ID.
	xiii.	 POST /api/claims: Create a new claim.
	xiv. 	PUT /api/claims/{id}: Update a claim's information.
	xv.	 DELETE /api/claims/{id}: Delete a claim.

Exception Handling and validation:
	The platform uses Spring's exception handling framework to handle exceptions and returns appropriate error messages to the client in json format.
For example, when the project gets a request for a client/policy/claim resource which does not exists in the database by the given id, this platform gives the response
as
	{
		"message": "Policy not found with the given id: 10",
		"status": false
	}

	This platform also validates the input data to ensure the data integrity. For example the input for claimDate field should be in the format 'yyyy-mm-dd'
if the requests sends with any other format it gives message as "Date format should be in yyyy-mm-dd". And if some of the fields are kept null, the platform 
shows error message as
	{
		"message":" Name cannot be empty"
	}

conclusion:
	This insurance management platform provides a range of features and functionalities for managing clients, policies and claims. It is built using SpringBoot 
and java. And it uses a layered architecture to ensure seperation of concerns and maintability. The platform also includes proper exception handling and validation 
proper API usage and integrity.












