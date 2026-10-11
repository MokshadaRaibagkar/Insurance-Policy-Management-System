# Insurance Policy Management System

## Overview
A Java-based console application that manages insurance policies. This project demonstrates Core Java concepts through practical implementation of policy management operations.

## Features
- Add insurance policies
- Search policies by policy ID
- Update policy details
- Cancel policies
- View all policies
- Validate policy details
- Prevent duplicate policy IDs
- Handle errors using custom exceptions

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (`ArrayList`)
- Exception Handling
- Eclipse IDE

## Project Structure
- `com.insurance` — Application entry point
- `com.insurance.model` — Policy model
- `com.insurance.service` — Policy management logic
- `com.insurance.exception` — Custom exception classes

## Current Status
The core policy management operations are implemented using in-memory storage. MySQL database integration using JDBC is planned as the next development step.

## How to Run
1. Import the project into Eclipse as an existing Java project.
2. Ensure the JDK is configured.
3. Run `Main.java` as a Java application.

## Future Enhancements
- Integrate MySQL using JDBC for persistent storage
- Add customer and claim management
- Consider REST API support
- Add automated tests
