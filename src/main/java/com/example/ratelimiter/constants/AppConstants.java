package com.example.ratelimiter.constants;

public final class AppConstants {
    private AppConstants() {
        // Private constructor to prevent instantiation
    }

    // API Endpoints
    public static final String API_BASE_PATH = "/api";
    public static final String TEST_ENDPOINT = "/test";

    // Headers
    public static final String USER_ID_HEADER = "X-User-ID";

    // Messages
    public static final String REQUEST_ALLOWED = "Request allowed";
    public static final String RATE_LIMIT_EXCEEDED = "Rate limit exceeded. Please try again later.";

    // Redis Keys
    public static final String RATE_LIMIT_KEY_PREFIX = "rate_limit:";

    // Rate Limiting
    public static final int MAX_REQUESTS_PER_MINUTE = 50;
} 