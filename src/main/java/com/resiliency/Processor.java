package com.resiliency;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Processor {

    public static int process(Integer integer) {
        System.out.println("Calling api : " + integer);
        String url = "https://google.com";
        ResponseEntity<String> re = new RestTemplate().getForEntity(url, String.class);
        System.out.println(re.toString());
        return integer;
    }
}
