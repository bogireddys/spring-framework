package com.bogireddy.springdemo.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Company {

    public void companyName() {
        System.out.println("Company is Accenture");
    }
}
