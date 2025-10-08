# 🌱 Plantitas Urbanas

A Java console application for managing an urban plant shop. This project demonstrates core Object-Oriented Programming (OOP) concepts including inheritance, polymorphism, encapsulation and exception handling.

## 📋 Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [OOP Concepts Used](#oop-concepts-used)
- [Technologies](#technologies)

## ✨ Features

- **Product Management**
  - Add, update, delete and view plants, tools and fertilizers
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

## 📁 Project Structure

```
plantitas-urbanas/
├── src/
│   ├── model/                    # Domain models (entities)
│   │   ├── Product.java          # Abstract base class for all products
│   │   ├── Plant.java            # Plant product (extends Product)
│   │   ├── Tool.java             # Tool product (extends Product)
│   │   ├── Fertilizer.java       # Fertilizer product (extends Product)
│   │   ├── Category.java         # Enum for product categories
│   │   ├── User.java             # Customer entity
│   │   └── Order.java            # Order entity
│   ├── service/                  # Business logic layer
│   │   ├── IService.java         # Generic service interface
│   │   ├── ProductService.java   # Product CRUD operations
│   │   ├── UserService.java      # User CRUD operations
│   │   └── OrderService.java     # Order management
│   ├── exception/                # Custom exception classes
│   │   ├── NotFoundException.java
│   │   ├── InvalidDataException.java
│   │   └── DuplicateException.java
│   ├── util/                     # Utility classes
│   │   ├── Validator.java        # Input validation helpers
│   │   └── InputReader.java      # Console input handling
│   ├── menu/                     # Menu handlers (UI layer)
│   │   ├── MainMenu.java         # Main application menu
│   │   ├── ProductMenu.java      # Product management menu
│   │   ├── UserMenu.java         # User management menu
│   │   └── OrderMenu.java        # Order management menu
│   └── Main.java                 # Application entry point
└── README.md
```

## OOP Concepts Used

### 1. **Inheritance**
- `Product.java` is an abstract base class
- `Plant.java`, `Tool.java` and `Fertilizer.java` extend `Product`

```java
public abstract class Product {
    // Common properties and methods
}

public class Plant extends Product {
    // Specific to plants
}
```

### 2. **Polymorphism**
- `IService<T>` interface defines a generic contract
- Different service classes implement the same interface
- Products can be treated as `Product` type regardless of specific subclass

### 3. **Encapsulation**
- Private fields with public getters/setters
- Data validation in setters
- Hiding implementation details

### 4. **Abstraction**
- Abstract `Product` class
- `IService<T>` interface for service layer
- Separation of concerns (model, service, menu layers)

### 5. **Exception Handling**
- Custom exceptions for specific error cases
- Try-catch blocks for user input validation
- Graceful error messages

### 6. **Enums**
- `Category.java` defines fixed set of product categories

## Technologies

- **Language**: Java
- **Version**: Java 8+
- **Architecture**: Layered (Model-Service-UI)
- **Design Patterns**: Service Layer, Factory (implicit)


## 👤 Author

**Helga Zambrana**
- Learning Java through hands-on project development
