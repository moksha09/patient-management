# Patient Management System

A production-oriented **Patient Management System built with Java and Spring Boot using a microservices architecture**. The project demonstrates how multiple independent services communicate with each other and how a distributed backend application can be secured, containerized, tested, and deployed using modern cloud-native technologies.

## Overview

The system is designed around multiple microservices responsible for different business capabilities, including patient management, billing, authentication, and analytics.

The project explores both **synchronous and asynchronous communication patterns**:

* **REST APIs** for client-facing communication
* **gRPC** for synchronous service-to-service communication
* **Apache Kafka** for asynchronous event-driven communication

An **API Gateway** acts as the entry point to the system and integrates with the authentication service to validate JWT tokens before forwarding requests to downstream services.

The services are containerized using **Docker** and the infrastructure is defined using **AWS CloudFormation**, with **LocalStack** used to emulate AWS services locally during development.

## Architecture

The system consists of the following major components:

* **Patient Service** – Handles patient CRUD operations and publishes patient events.
* **Billing Service** – Provides billing functionality through gRPC.
* **Analytics Service** – Consumes patient events from Kafka for analytics processing.
* **Auth Service** – Handles user authentication, password encoding, JWT generation, and token validation.
* **API Gateway** – Provides a single entry point, routes requests to services, and performs JWT validation.
* **PostgreSQL** – Persistent storage for the application services.
* **Apache Kafka** – Enables event-driven communication between services.
* **Docker** – Containerizes individual services and infrastructure components.
* **AWS / LocalStack** – Used to explore cloud deployment and infrastructure provisioning.

## Key Technologies

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **Spring Cloud Gateway**
* **Spring Security**
* **JWT**
* **gRPC & Protocol Buffers**
* **Apache Kafka**
* **PostgreSQL**
* **Docker & Docker Compose**
* **AWS**
* **AWS CloudFormation**
* **LocalStack**
* **JUnit / Integration Testing**
* **OpenAPI / Swagger**

## Key Concepts Implemented

### Microservices Architecture

The application is divided into independently deployable services with clearly separated responsibilities.

### REST APIs

The Patient Service exposes REST endpoints for operations such as:

* Create patient
* Retrieve patients
* Update patient
* Delete patient

Request validation, business logic, custom exceptions, and centralized error handling are also implemented.

### gRPC Communication

The Patient Service communicates synchronously with the Billing Service using **gRPC and Protocol Buffers**.

This demonstrates an alternative to REST for efficient internal service-to-service communication.

### Event-Driven Architecture with Kafka

Patient-related events are published to **Apache Kafka** when relevant operations occur.

The Analytics Service consumes these events asynchronously, demonstrating how services can communicate without being tightly coupled.

### API Gateway

The API Gateway provides a centralized entry point for client requests and handles routing between services.

It also integrates with the authentication service to validate JWT tokens before allowing access to protected endpoints.

### Authentication & Authorization

The Auth Service implements:

* User authentication
* Password encoding using Spring Security
* JWT token generation
* JWT token validation
* Gateway-level JWT filtering

### Containerization

Each microservice is packaged into a Docker image, allowing the complete distributed system to be run consistently across environments.

### Testing

Integration tests are included for important application flows such as:

* Login
* Unauthorized requests
* Retrieving patients

### Cloud Infrastructure

The project also explores deploying the microservices architecture using AWS services and Infrastructure as Code.

AWS CloudFormation is used to provision infrastructure including:

* VPC
* Databases
* MSK/Kafka cluster
* ECS cluster
* ECS services
* Load balancing

**LocalStack** is used to reproduce and test the AWS infrastructure locally.



## Project Goal

The primary goal of this project was to gain practical experience building a **real-world backend system using microservices and cloud-native technologies**, rather than working with a single monolithic Spring Boot application.
