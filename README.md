# URL Shortener

A backend URL Shortener application built with Java and Spring Boot, similar to Bit.ly. It converts long URLs into short codes, tracks click counts, and handles link expiry.

## Tech Stack
- Java 21
- Spring Boot 3.5.14
- Spring Data JPA
- MySQL
- Maven

## Features
- Shorten any long URL into a short code
- Redirect short URLs to their original destination
- Track number of clicks per short URL
- Automatic link expiry (30 days from creation)
- Centralized exception handling with proper HTTP status codes (404, 410)
- Top 5 most-clicked URLs leaderboard

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|--------------|
| POST | `/shorten` | Creates a short URL from a long URL |
| GET | `/r/{shortCode}` | Redirects to the original URL, tracks clicks, checks expiry |
| GET | `/top5` | Returns the top 5 most-clicked URLs |

## Architecture

This project follows a layered architecture:
- **Model** – Defines the `Url` entity structure
- **Repository** – Handles database operations using Spring Data JPA
- **Service** – Contains business logic (short code generation, expiry checks, click tracking)
- **Controller** – Handles HTTP requests and responses
- **Exception Handling** – Centralized using `@RestControllerAdvice`

## How to Run Locally

1. Clone this repository
2. Set up a MySQL database
3. Update `application.properties` with your database credentials
4. Run `UrlshortenerApplication.java`
5. Test endpoints using Postman on `http://localhost:8081`

## Author
Kalluri Mokshagna Sai Teja
