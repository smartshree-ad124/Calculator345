Calculator Application with Email – Documentation
1. Project Overview

This is a simple web-based calculator application developed using Spring Boot and Thymeleaf, with the additional functionality of sending calculation results to an email.

Users can perform Addition, Subtraction, Multiplication, and Division.

Optional: Results can be sent to a user-provided email address.

Technology Stack:

Backend: Spring Boot

Frontend: Thymeleaf, HTML

Email Service: Spring Boot Mail (SMTP)

Build Tool: Maven

2. Project Structure
calculator-email-sb/
 ├─ src
 │   ├─ main
 │   │   ├─ java
 │   │   │   └─ com/example34/demo34/
 │   │   │       ├─ Demo34Application.java
 │   │   │       ├─ CalculatorController.java
 │   │   │       └─ EmailService.java
 │   │   └─ resources
 │   │       ├─ application.properties
 │   │       └─ templates/
 │   │           ├─ index.html
 │   │           └─ result.html
 └─ pom.xml


CalculatorController.java → Handles requests, performs calculations, and triggers email sending.

EmailService.java → Sends email using Spring Boot Mail.

index.html → Calculator input form (numbers, operation, email).

result.html → Displays result and optional email confirmation.

application.properties → Configures SMTP email settings.

3. Key Files
3.1 CalculatorController.java

@GetMapping("/") → Loads calculator form.

@PostMapping("/calculate") → Calculates result and optionally sends email.

Uses Model to pass data to Thymeleaf templates.

3.2 EmailService.java

Autowired with JavaMailSender.

Sends result to email using SimpleMailMessage.

3.3 Thymeleaf Templates

index.html: User input form with fields for two numbers, operation, and optional email.

result.html: Displays calculation result and optional email confirmation.

3.4 application.properties (example)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your.email@gmail.com
spring.mail.password=YOUR_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
app.mail.from=your.email@gmail.com

4. How to Run

Build the project:

Right-click project → Run As → Maven Install


Run the application:

Right-click Demo34Application.java → Run As → Java Application


Open browser:

http://localhost:8080


Use the calculator form, enter numbers, select operation, optionally enter email, and click Calculate.

5. Features

Basic calculator operations: Add, Subtract, Multiply, Divide

Optional email sending for result

Uses Spring Boot + Thymeleaf for web interface

Clean folder structure for maintainability

6. Notes

Email functionality requires valid SMTP configuration. For Gmail, generate an App Password if using 2FA.

The project is lightweight and easy to extend with more features like history tracking or advanced math operations.
