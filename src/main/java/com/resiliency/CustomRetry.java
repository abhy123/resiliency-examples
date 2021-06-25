package com.resiliency;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;

import java.time.Duration;
import java.util.function.Function;

public class CustomRetry {

    public static void retry() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofMillis(5000))
                .build();
        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("retry");
        Function<Integer, Void> decorated
                = Retry.decorateFunction(retry, (Integer s) -> {
            Processor.process(s);
            return null;
        });

        try {
            decorated.apply(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
