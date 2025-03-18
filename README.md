# kotlin-idp

## CosmosDB and MongoDB Integration

This project demonstrates how to integrate CosmosDB with MongoDB using Kotlin. CosmosDB is a globally distributed, multi-model database service provided by Microsoft Azure. MongoDB is a popular NoSQL database known for its flexibility and scalability.

## CRUD Operations

The project exposes CRUD (Create, Read, Update, Delete) operations for interacting with CosmosDB. The following endpoints are available:

- `POST /create`: Create a new document in CosmosDB.
- `GET /read`: Read a document from CosmosDB.
- `PUT /update`: Update an existing document in CosmosDB.
- `DELETE /delete`: Delete a document from CosmosDB.

## JWT Token Generation

The project also includes an endpoint to generate a JWT (JSON Web Token) with claims from CosmosDB. The following endpoint is available:

- `GET /generate-token`: Generate and return a JWT token with claims.
