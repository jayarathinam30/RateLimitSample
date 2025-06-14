package com.example.ratelimiter.service;

import com.example.ratelimiter.constants.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RateLimiterService {

    private final RedisTemplate<String, String> redisTemplate;

    public boolean isAllowed(String userId) {
        String key = AppConstants.RATE_LIMIT_KEY_PREFIX + userId;
        
        // Get current count
        String currentCountStr = redisTemplate.opsForValue().get(key);
        int currentCount = currentCountStr == null ? 0 : Integer.parseInt(currentCountStr);

        if (currentCount >= AppConstants.MAX_REQUESTS_PER_MINUTE) {
            return false;
        }

        // Increment the counter
        redisTemplate.opsForValue().increment(key);
        
        // Set expiration if this is the first request
        if (currentCount == 0) {
            redisTemplate.expire(key, Duration.ofMinutes(1));
        }

        return true;
    }
} 