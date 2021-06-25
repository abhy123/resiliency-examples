package com.resiliency;

import org.junit.Test;

public class ResiliencyTest {

  @Test
  public void testCustomRateLimiter() {
    CustomRateLimiter.rateLimiter();
  }

  @Test
  public void testCustomCircuitBreaker() {
    CustomCircuitBreaker.circuitbreaker();
  }

  @Test
  public void testCustomRetry() {
    CustomRetry.retry();
  }

  @Test
  public void testCustomBulkhead() throws InterruptedException {
    CustomBulkhead.bulkHead();
  }

}
