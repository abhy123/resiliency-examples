package com.resiliency;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;

import java.time.Duration;
import java.util.function.Function;

public class CustomRateLimiter {

    public static void rateLimiter() {
        RateLimiterConfig rlc = RateLimiterConfig
                .custom()
                .limitForPeriod(3)
                .limitRefreshPeriod(Duration.ofSeconds(10))
                .timeoutDuration(Duration.ofMillis(25))
                .build();
        RateLimiterRegistry reg = RateLimiterRegistry.of(rlc);
        RateLimiter rl = reg.rateLimiter("reg");
        Function<Integer, Integer> decorated
                = RateLimiter.decorateFunction(rl, Processor::process);
        for (int i = 1; i <= 5; i++) {
            try {
                decorated.apply(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
