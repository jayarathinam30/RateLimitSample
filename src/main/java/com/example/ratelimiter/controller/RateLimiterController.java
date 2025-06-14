package com.example.ratelimiter.controller;

import com.example.ratelimiter.constants.AppConstants;
import com.example.ratelimiter.service.RateLimiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppConstants.API_BASE_PATH)
@RequiredArgsConstructor
public class RateLimiterController {


    private final RateLimiterService rateLimiterService;


    

    @GetMapping(AppConstants.TEST_ENDPOINT)
    public ResponseEntity<String> testRateLimit(@RequestHeader(AppConstants.USER_ID_HEADER) String userId) {
        if (rateLimiterService.isAllowed(userId)) {
            return ResponseEntity.ok(AppConstants.REQUEST_ALLOWED);
        } else {
            return ResponseEntity.status(429).body(AppConstants.RATE_LIMIT_EXCEEDED);
        }
    }
} 