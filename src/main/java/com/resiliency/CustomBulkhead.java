package com.resiliency;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;

import java.util.function.Function;

public class CustomBulkhead {

    public static void bulkHead() throws InterruptedException {
        BulkheadConfig bhc = BulkheadConfig.custom().maxConcurrentCalls(1).build();
        BulkheadRegistry bhr = BulkheadRegistry.of(bhc);
        Bulkhead bh = bhr.bulkhead("my");
        Function<Integer, Integer> decorated
                = Bulkhead.decorateFunction(bh, Processor::process);
        Thread t1 =
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                decorated.apply(1);
                            }
                        });
        Thread t2 =
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                decorated.apply(2);
                            }
                        });
        Thread t3 =
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                decorated.apply(3);
                            }
                        });
        t1.start();t2.start();t3.start();


        System.out.println("Bulkhead : " + bh.getMetrics().getAvailableConcurrentCalls());
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Done");
    }
}
