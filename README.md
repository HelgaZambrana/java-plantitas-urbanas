# 🌱 Plantitas Urbanas

A Java console application for managing an urban plant shop. This project demonstrates core Object-Oriented Programming (OOP) concepts including inheritance, polymorphism, encapsulation and exception handling. (IN PROGRESS)

## Table of Contents
- [MVP Features](#features)
- [Project Structure](#project-structure)
- [OOP Concepts Used](#oop-concepts-used)
- [Technologies](#technologies)

## MVP Features

- **Product Management**
  - Add, update, delete and view products
  - Categorize products
  - Track inventory

- **User Management**
  - Register customers
  - View customer information
  - Update customer details

- **Order Management**
  - Create orders
  - Add products to orders
  - Calculate order totals
  - View order history


## Project Structure

```
plantitas-urbanas/
├── src/
│   ├── model/                    # Domain models (entities)
│   │   ├── Item.java
│   │   ├── Product.java          
│   │   ├── Category.java
│   │   ├── User.java
│   │   └── Order.java
│   ├── service/                  # Business logic layer
│   │   ├── IService.java
│   │   ├── ProductService.java
│   │   ├── UserService.java
│   │   ├── OrderService.java
│   ├── exception/                # Custom exception classes (TO BE DONE)
│   ├── util/                     # Utility classes (TO BE DONE)
│   ├── menu/                     # Menu handlers (TO BE DONE)
│   └── Main.java                 # Application entry point
└── README.md
```

## OOP Concepts Used
- **Classes & Objects**: Implemented core entities (Product, User, Order, Item) and service classes
- **Inheritance**: `Product extends Item` - specialized product class inherits from abstract base class
- **Abstract Class**: `Item` serves as abstract parent with shared attributes (id, name, price, description) and abstract method `getTypeDescription()`
- **Encapsulation**: All attributes are `private` with controlled access through getters/setters
- **Polymorphism**: Method overriding in `toString()` and `getTypeDescription()` across different classes
- **Interface**: `IService<T>` generic interface implemented by ProductService, UserService, and OrderService
- **Collections**: `ArrayList` used throughout service classes for data management
- **Data Validation**: Input validation in setters (price, stock, email, phone) with exception handling


## Technologies

- **Language**: Java
- **Version**: Java 8+
- **Architecture**: Layered (Model-Service-UI)
- **Design Patterns**: Service Layer, Factory (implicit)


## Author

**Helga Zambrana**
- Learning Java through hands-on project development