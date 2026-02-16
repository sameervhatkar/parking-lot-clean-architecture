# 🚗 Parking Lot – Clean Architecture Implementation

A modular and extensible Parking Lot system built using clean architecture principles, SOLID design practices, and unit testing with JUnit.

This project focuses on clarity, maintainability, and proper abstraction boundaries rather than over-engineering.

---

## 🚀 Features

- Multi-floor parking support
- VIP-only floor restriction
- Slot allocation strategy
- Configurable pricing strategy
- Ticket generation & validation
- Layered architecture:
    - Controller
    - Service
    - Repository
    - Domain
- Proper exception handling
- Maven-based project structure
- Unit testing using JUnit 5

---

## 🏗 Architecture Overview

The project follows clean separation of concerns: 
~~~
Controller → Service → Repository → Domain
~~~

### 📌 Design Principles Applied

- Single Responsibility Principle (SRP)
- Open/Closed Principle (OCP)
- Dependency Inversion Principle (DIP)
- Interface Segregation Principle (ISP)

### 📌 Design Patterns Used

- Strategy Pattern (for floor allocation and pricing)
- Constructor-based Dependency Injection
- Layered Architecture

---

## 🧪 Testing

The project includes unit tests written using JUnit 5.

### Tested Components:

- Slot behavior (park, unpark, validation)
- VIP floor restriction logic
- Capacity handling
- Pricing calculation logic
- Exception scenarios

All core domain logic is validated independently of UI.

---

## 📦 Project Structure
~~~
src
├── main
│    └── java
│         ├── controller
│         ├── core
│         ├── entity
│         ├── enum_
│         ├── exception
│         ├── repository
│         ├── service
│         └── strategy
└── test
└── java
~~~
---

## 🔄 Related Project – Previous Parking Lot Implementation

This repository is an improved and architecturally refined version of my earlier Parking Lot project.

👉 Previous Project:  
https://github.com/sameervhatkar/Parking-Lot

### 🔍 Key Differences

| Previous Version | Current Version |
|------------------|-----------------|
| Feature-rich and enterprise-style | Clean architecture focused |
| Heavy use of factories and abstractions | Incrementally evolved design |
| Larger domain model (Gate, Payment, Bill, etc.) | Simplified and focused domain |
| No unit testing | Fully unit tested (JUnit 5) |
| Pattern usage more theoretical | Patterns applied based on actual need |
| Over-engineered in parts | Balanced and maintainable |

### 🎯 Why This Version?

The goal of this version was to:

- Apply SOLID principles more consciously
- Improve testability
- Avoid premature over-engineering
- Demonstrate backend architectural maturity
- Build incrementally with design evolution

Both projects represent different stages of my design evolution.

---

## ⚙️ How to Run

1. Clone the repository
2. Open in IntelliJ
3. Ensure Maven dependencies are loaded
4. Run `Main.java`

---

## 🏆 Tech Stack

- Java 22
- Maven
- JUnit 5

---

## 📌 Future Improvements

- Observer pattern for display boards
- Admin operations for dynamic floor management
- Concurrency handling for parallel parking requests
- Bill generation and payment processing module 
---

## 👨‍💻 Author

Sameer Vhatkar  
Backend Developer | Java | System Design Enthusiast


