# 🎓 Student Management System - Java Project

## 🌟 Project Overview

This project is a simple Student Management System developed using Java Swing and MySQL database.  
It allows users to manage student records by adding, viewing, updating, and deleting student information.

The system performs CRUD operations using JDBC connectivity.

------------------------------------------------------------

## 🛠️ Technologies Used

• Java (Swing GUI)  
• JDBC Connectivity  
• MySQL Database  
• IntelliJ IDEA / Eclipse / NetBeans  

------------------------------------------------------------

## 📂 Project Features

✔ Add Student  
✔ View Students  
✔ Update Student  
✔ Delete Student  
✔ Database Connectivity  
✔ Auto Increment Student ID  
✔ PreparedStatement for secure queries  

------------------------------------------------------------

## 💾 Database Setup

### 1. Install Database Server

Install and start:

• MySQL Server  

### 2. Create Database

Run the following SQL command:

CREATE DATABASE student_db;

### 3. Create Table

USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    course VARCHAR(100),
    marks INT
);

------------------------------------------------------------

## ⚙️ JDBC Configuration

Update database connection in StudentManagement.java:

con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/student_db?useSSL=false&allowPublicKeyRetrieval=true",
    "root",
    "your_password"
);

⚠️ Note: Do not upload your database password on public GitHub repositories.

------------------------------------------------------------

## 🚀 How to Run Project

1. Install Java JDK
2. Install MySQL Server
3. Create database using above SQL
4. Save StudentManagement.java file
5. Open terminal in project folder
6. Compile the program:

   javac StudentManagement.java

7. Run the program:

   java StudentManagement

------------------------------------------------------------

## 📌 Project Structure

StudentManagementProject/
│
├── src/
│   └── StudentManagement.java
├── database.sql
├── README.md

------------------------------------------------------------

## 🔐 System Workflow

1. User enters student details (Name, Course, Marks).
2. Click "Add" to store data in database.
3. Click "View" to display all student records.
4. Enter ID to update or delete specific student.
5. Database handles auto-increment ID.

------------------------------------------------------------

## ❤️ Developer Information

• Language: Java  
• Type: Mini Project  
• Platform: Desktop Application  
• Database: MySQL  

------------------------------------------------------------

## ⭐ Future Improvements

• Search Student Feature  
• Result (Pass/Fail) Calculation  
• Improved UI Design  
• Login Authentication System  

------------------------------------------------------------

✨ Thank you for using Student Management System Project!
