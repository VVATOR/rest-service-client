## rest-service-client
REST service and client

# Task4

# Web Service

Implement RESTful Web Service for manipulating Documents. Use in-memory storage.

Document has:

- Id

- Name

- Chapters

Chapter has:

- Id

- Chapter number

- Number of pages

Implement functionality for CRUD operations for Documents’ service.

Web Service should consume objects in JSON format and return objects in XML format.

Implement method for getting Document with the shortest Chapter.

In case of getting Document’s Chapters – 501 status code with appropriate message should be set to

response.

Exceptions’ catching should be realized using ExceptionMapper.

# Client

Implement HTTP client for the Web Service above.

Demonstrate work of the Web Service using the Client.
