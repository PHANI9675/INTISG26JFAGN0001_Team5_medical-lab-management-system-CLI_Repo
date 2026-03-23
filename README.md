# Medical Laboratory Management System (CLI)

A Java-based backend system that simulates a real-world laboratory
workflow using JDBC and MySQL. This project demonstrates core backend
engineering concepts such as layered architecture, authentication, state
management, and database integration.

## Features

-   User Authentication (Register/Login)
-   Role-Based Access Control (Admin/User)
-   Patient Management
-   Test Order Management
-   Sample Lifecycle Management (PENDING → COLLECTED → PROCESSING →
    COMPLETED)
-   Report Generation
-   Notification System
-   Execution Time Tracking
-   Basic JUnit Testing

##  Tech Stack

-   Java
-   JDBC
-   MySQL
-   JUnit

##  Setup Instructions

1.  Clone repo
2.  Run schema.sql in MySQL
3.  Configure DBConnection.java
4.  Run Main.java

## Authentication

Admin passcode: ADMIN123

## Workflow

Patient → Order → Sample → Report → Notification
