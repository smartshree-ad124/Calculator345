1. Overview

A simple calculator web application with frontend (Angular), backend (Spring Boot), and database (MySQL). It allows users to perform arithmetic operations, store calculation history, and optionally send results via email.

2. Folder Structure
project-root/
├── calculator-frontend/       # Angular app (UI)
│   ├── src/app/
│   │   ├── components/       # Calculator UI components
│   │   ├── services/         # HTTP service for API calls
│   │   ├── models/           # Interfaces and data models
│   │   └── app.module.ts
│   └── environments/         # environment.ts and environment.prod.ts
│
├── calculator-backend/        # Spring Boot app (API + logic)
│   ├── src/main/java/com/example/calculator/
│   │   ├── controller/       # REST controllers (API endpoints)
│   │   ├── service/          # Business logic
│   │   ├── repository/       # JPA repositories
│   │   ├── model/            # Entity classes (User, Calculation)
│   │   └── CalculatorApplication.java
│   └── src/main/resources/
│       ├── application.properties  # DB and mail configuration
│       └── static/ or templates/   # Optional web resources
│
├── database/                  # SQL scripts or migration files
│   └── schema.sql
│
├── docker-compose.yml         # For container setup (MySQL + backend + frontend)
└── README.md                  # Basic instructions
3. Tech Stack

Frontend: Angular (TypeScript)

Backend: Spring Boot (Java)

Database: MySQL

Email: JavaMailSender / SendGrid

Deployment: Docker / Netlify / Render

4. Data Flow

User performs calculation on Angular UI.

Request sent to Spring Boot API.

Backend evaluates and stores result in MySQL.

Optional: backend sends result email.

Angular displays result and updates history.

5. Example API Endpoints
Method	Endpoint	Description
POST	/api/calc/evaluate	Evaluate expression
GET	/api/calc/history	Get calculation history
POST	/api/email/send	Send calculation email
6. Quick Run Steps
# Backend
cd calculator-backend
./mvnw spring-boot:run


# Frontend
cd calculator-frontend
npm install
ng serve --open


# Database
MySQL running on localhost:3306 with schema 'calculator'
7. Hosting

Frontend: Netlify or Vercel

Backend: Render, Railway, or AWS EC2

Database: MySQL on Cloud (e.g., PlanetScale, AWS RDS)

End of short documentation.
