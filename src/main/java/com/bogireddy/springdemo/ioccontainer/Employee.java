package com.bogireddy.springdemo.ioccontainer;

import com.bogireddy.springdemo.dependencyinjection.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Autowired
    Company company;

    public void shiftTimings() {
        System.out.println("Shift timings are 9 AM to 6 PM");
        company.companyName();
    }
}
