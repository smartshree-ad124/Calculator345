Spring Boot Calculator Application – Documentation
1. Project Overview

This is a simple, modern web-based calculator built with Spring Boot and Thymeleaf.

Users can perform Addition, Subtraction, Multiplication, and Division.

Single-page UI with responsive and clean design using Bootstrap.

Lightweight and easy to extend.

Technology Stack:

Backend: Spring Boot (Java)

Frontend: Thymeleaf + HTML + Bootstrap

Build Tool: Maven

2. Project Structure
calculator-app/
 ├─ src
 │   ├─ main
 │   │   ├─ java
 │   │   │   └─ com/example34/demo34/
 │   │   │       ├─ Demo34Application.java
 │   │   │       └─ CalculatorController.java
 │   │   └─ resources
 │   │       └─ templates/
 │   │           └─ calculator.html
 └─ pom.xml


Demo34Application.java → Main Spring Boot application class.

CalculatorController.java → Handles calculation requests.

calculator.html → Single-page UI for user input and displaying results.

3. Key Files
3.1 CalculatorController.java

@GetMapping("/") → Loads calculator page.

@PostMapping("/calculate") → Performs calculation and returns same page with results.

Handles divide by zero error inline.

3.2 calculator.html

Uses Bootstrap for modern UI.

Inputs for two numbers and operation selection.

Displays result and error message on the same page.

Example snippet:

<form th:action="@{/calculate}" method="post">
    <input type="number" name="num1" placeholder="First number" required>
    <input type="number" name="num2" placeholder="Second number" required>
    <select name="operation">
        <option value="add">Add</option>
        <option value="sub">Subtract</option>
        <option value="mul">Multiply</option>
        <option value="div">Divide</option>
    </select>
    <button type="submit">Calculate</button>
</form>

<p th:text="'Result: ' + ${result}"></p>
<p th:text="${error}"></p>

4. How to Run

Build the project (optional):

Right-click project → Run As → Maven Install


Run the application:

Right-click Demo34Application.java → Run As → Java Application


Open browser → http://localhost:8080

Enter numbers, select operation, and click Calculate.

Result appears on the same page, errors shown inline.

5. Features

Basic calculator operations: Add, Subtract, Multiply, Divide

Single-page modern UI using Bootstrap

Responsive design for desktop and mobile

Error handling for invalid operations (divide by zero)

Lightweight and easy to extend


This version does not include email functionality, keeping it simple.

Can be hosted on free services like Railway, Render, or Heroku to get a live URL.
