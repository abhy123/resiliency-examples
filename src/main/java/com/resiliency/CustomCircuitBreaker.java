package com.resiliency;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

import java.time.Duration;
import java.util.function.Function;

public class CustomCircuitBreaker {

    public static void circuitbreaker() {
        CircuitBreakerConfig cbc =
                CircuitBreakerConfig.custom()
                        .failureRateThreshold(20)
                        .minimumNumberOfCalls(5)
                        .waitDurationInOpenState(Duration.ofMillis(10000))
                        .build();

        CircuitBreakerRegistry cbr = CircuitBreakerRegistry.of(cbc);
        CircuitBreaker cb = cbr.circuitBreaker("cbmy");
        Function<Integer, Integer> decorated =
                CircuitBreaker.decorateFunction(cb, Processor::process);
        for (int i = 0; i < 10; i++) {

            try {
                System.out.println(cb.getState());
                //cb.transitionToClosedState();
                decorated.apply(i);

            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }
}
