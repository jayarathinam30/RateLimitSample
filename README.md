# Rate Limiter Service

A Spring Boot application that implements rate limiting per user using Redis.

## Features

- Rate limiting per user (50 requests per minute)
- Distributed rate limiting using Redis
- Thread-safe implementation
- Scalable across multiple instances

## Prerequisites

- Java 11 or higher
- Maven
- Redis Server

## Configuration

The application uses the following default configuration:
- Server port: 8080
- Redis host: localhost
- Redis port: 6379

You can modify these settings in `src/main/resources/application.properties`

## Running the Application

1. Start Redis server
2. Run the application:
```bash
mvn spring-boot:run
```

## Testing the API

Send requests to the test endpoint with a user ID header:

```bash
curl -H "X-User-ID: user123" http://localhost:8080/api/test
```

The API will:
- Allow up to 50 requests per minute per user
- Return HTTP 200 OK for allowed requests
- Return HTTP 429 Too Many Requests when the rate limit is exceeded

## Project Structure

```
src/main/java/com/example/ratelimiter/
├── RateLimiterApplication.java
├── config/
│   └── RateLimiterConfig.java
├── constants/
│   └── AppConstants.java
├── controller/
│   └── RateLimiterController.java
└── service/
    └── RateLimiterService.java
``` 