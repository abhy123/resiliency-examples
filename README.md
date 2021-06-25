Run tests in junit class ResiliencyTest.java

1. testCustomRateLimiter()
Rate Limiter will make sure only three calls are made 
   within the specified time i.e. 10 seconds.
   
2. testCustomCircuitBreaker()
If the url called fails 20% of the times api is called, then the circuit breaks.
   Just modify the url to a wrong one in Processor.java - process method.
   
3. testCustomRetry()
The CustomRetry class attempts the api call 5 times with a wait of 
   5 seconds before stopping the process.
   
4. testCustomBulkhead()
The CustomBulkhead class has a max concurrency of 1 setup, what that means
   despite we are making three calls, it fails two of them.