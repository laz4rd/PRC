📘 Java Fundamentals – 20 Programs

This repository contains 20 beginner-to-intermediate level Java programs, each demonstrating a key concept of Object-Oriented Programming (OOP), control structures, exceptions, file handling, and more.

Each program is self-contained (unless stated otherwise) and can be compiled and run independently using:

javac FileName.java
java FileName

🧩 Program Index & Description
No.	Topic	File	Description
1	Variables & Operators	Question1.java	Calculates the Gross Salary of an employee, where HRA = 20%, DA = 50%, and PF = 11% of the basic salary. Demonstrates use of variables and arithmetic operators.
2	Classes & Objects	Question2.java	Defines a Student class with rollNo, name, and marks. Accepts and displays details of 3 students. Demonstrates basic class usage and object creation.
3	Decision Making (if-else)	Question3.java	Checks if a number entered by the user is even or odd using an if-else statement.
4	Arrays	Question4.java	Inputs 5 integers, stores them in an array, and displays the maximum and minimum numbers. Demonstrates basic array operations and looping.
5	Constructor & this keyword	Question5.java	Creates a Rectangle class initialized via a constructor. Uses this to distinguish between instance variables and parameters. Includes a method to calculate area.
6	Loop & Logic (Fibonacci)	Question6.java	Displays the Fibonacci series up to n terms using a while loop. Demonstrates iteration and arithmetic logic.
7	Package Implementation	mypack/Calculator.java, Question7.java	Contains a mypack package with class Calculator having methods add() and subtract(). Another file imports and uses this package. Demonstrates custom packages and imports.
8	Exception Handling (throws)	Question8.java	Defines a readFile() method that declares throws IOException and handles it in main(). Demonstrates checked exceptions and the throws keyword.
9	Loop & Pattern Printing	Question9.java	Prints a right-angled triangle of stars (*) using nested for loops.
10	Generics	Question10.java	Creates a generic class Box<T> to store and display a single value for both Integer and String types. Demonstrates generic classes.
11	Exception Handling (ArithmeticException)	Question11.java	Divides two numbers and handles division by zero using a try-catch block.
12	Inheritance	Question12.java	Base class Employee and derived class Manager that adds department and bonus. Demonstrates single inheritance and member access.
13	Bounded Generics (Maximum Finder)	Question13.java	Defines a generic method maximum(T x, T y, T z) that returns the largest of three numbers. Works with integers and doubles.
14	File Handling	Question14.java	Creates a text file named example.txt and writes "Hello Java File Handling!" inside it using FileWriter.
15	Method Overriding	Question15.java	Base class Shape with subclasses Circle and Rectangle. Each overrides calculateArea(). Demonstrates method overriding.
16	Multiple Inheritance (Interfaces)	Question16.java	Two interfaces Printable and Shareable implemented by a single class Document. Demonstrates multiple inheritance via interfaces.
17	Static Keyword (Object Counter)	Question17.java	Class Student with a static variable counting total objects created. Displays count after each new object. Demonstrates use of static variables.
18	Interface (Payment System)	Question18.java	Interface Payment with method pay(). Implemented by CreditCardPayment and UPIPayment. Demonstrates polymorphism via interfaces.
19	Custom Exception (Invalid Age)	Question19.java	Defines custom exception InvalidAgeException. If age < 18, throws exception; else prints “Valid voter”. Demonstrates user-defined exceptions.
20	Runtime Polymorphism	Question20.java	Base class Account with subclasses SavingsAccount and FixedDepositAccount. Each overrides calculateInterest(). Demonstrates runtime polymorphism using base class reference.
🧱 Folder Structure
JavaFundamentals/
│
├── mypack/
│   └── Calculator.java       # Package implementation for Question 7
│
├── Question1.java
├── Question2.java
├── Question3.java
├── ...
├── Question20.java
│
└── README.md

🛠️ How to Run
# Compile a specific program
javac Question10.java

# Run the compiled class
java Question10


For the package program (Question7.java):

javac mypack/Calculator.java
javac -cp . Question7.java
java Question7

📚 Topics Covered

Variables, Operators, Control Flow

Loops & Patterns

Arrays and Constructors

Packages and Exceptions

Inheritance, Polymorphism, and Interfaces

Generics & Static Members

File Handling & Custom Exceptions

💡 Notes

Each file is independent unless it explicitly imports from mypack (in Question7).

Programs use Scanner for input and System.out.println() for output.

The structure is designed for educational clarity — demonstrating one concept per file