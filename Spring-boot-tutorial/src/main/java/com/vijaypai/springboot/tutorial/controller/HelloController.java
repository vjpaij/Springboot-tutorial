package com.vijaypai.springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${welcome.message}")
    private String welcomeMessage;

    /*@RequestMapping(value = "/v1/", method = RequestMethod.GET)
    Above line is verbose as in we are giving to many details. Now Get Request Mapping
    can be handled as below:
     */

    /*
    @GetMapping("/v1/")
    public String helloWorld() {
        return "Hello World Spring Boot!!!";
    }
    */

    //using @Value to remove above hardcoding and getting the value from property file

    @GetMapping("/v1/")
    public String helloWorld() {
        return welcomeMessage;
    }
}
