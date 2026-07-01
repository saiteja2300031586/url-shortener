# URL Shortener REST API

A backend URL Shortener application built with Java and Spring Boot, similar to Bit.ly. Converts long URLs into short codes, tracks clicks, handles link expiry, and is deployed live.

## Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Git/GitHub
- Railway (deployment)

## Features
- Shorten any long URL into a short code using Base62 encoding
- Redirect short URLs to their original destination
- Track number of clicks per short URL
- Automatic link expiry (30 days from creation)
- Centralized exception handling (404 Not Found, 410 Gone)
- Race condition fix using pessimistic locking (@Lock)
- Top 5 most-clicked URLs leaderboard

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/shorten` | Creates a short URL |
| GET | `/r/{shortCode}` | Redirects + tracks clicks + checks expiry |
| GET | `/top5` | Returns top 5 most-clicked URLs |

## Architecture
Controller → Service → Repository → MySQL Database

## Author
Kalluri Mokshagna Sai Teja
