package com.colwell.coding.swdocdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

}