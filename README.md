# Hotel Reservation System (Java CLI)

A **Command Line Interface (CLI) based Hotel Reservation Application** built in **Java** using **Object-Oriented Programming (OOP)** principles and **layered architecture**.

This application allows users to create accounts, search for available hotel rooms, make reservations, and view their bookings. It also provides an **admin interface** to manage rooms and view system data.

---

## Features

### Customer Features

* Create a customer account
* Search for available rooms
* Reserve a room
* View existing reservations

### Admin Features

* View all customers
* View all rooms
* View all reservations
* Add new rooms to the system

---

## Project Architecture

The project follows a **layered architecture** to separate responsibilities.

```
UI Layer (CLI Menus)
      ↓
API Layer (Resources)
      ↓
Service Layer (Business Logic)
      ↓
Model Layer (Data Classes)
```

### Folder Structure

```
src
 ├── api
 │     ├── AdminResource.java
 │     └── HotelResource.java
 │
 ├── model
 │     ├── Customer.java
 │     ├── FreeRoom.java
 │     ├── IRoom.java
 │     ├── Reservation.java
 │     ├── Room.java
 │     └── RoomType.java
 │
 ├── service
 │     ├── CustomerService.java
 │     └── ReservationService.java
 │
 ├── ui
 │     ├── AdminMenu.java
 │     └── MainMenu.java
 │
 └── Main.java
```

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Java Collections Framework
* Command Line Interface (CLI)
* IntelliJ IDEA
* Git & GitHub

---

## How to Run the Application

### 1. Clone the repository

```
git clone https://github.com/yourusername/hotel-reservation-system.git
```

### 2. Navigate to the project

```
cd hotel-reservation-system/src
```

### 3. Compile the program

```
javac Main.java
```

### 4. Run the application

```
java Main
```

---

## Example Menu

```
Main Menu
1. Find and reserve a room
2. See my reservations
3. Create an account
4. Admin
5. Exit
```

---

## Example Admin Menu

```
Admin Menu
1. See all Customers
2. See all Rooms
3. See all Reservations
4. Add a Room
5. Back to Main Menu
```

---

## Key Concepts Implemented

* Object-Oriented Design
* Interfaces and Inheritance
* Polymorphism
* Singleton Design Pattern
* Java Collections (HashMap, List)
* Input validation
* Modular architecture

---

## Future Improvements

* Add a graphical user interface (GUI)
* Implement database storage (MySQL / PostgreSQL)
* Add authentication for admin users
* Improve room recommendation logic

---

## Author

**Venkat R**

---

## License

This project is for educational purposes.
