package com.bogireddy.springdemo.springbootproject;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class JavaMain {

    @Value("printing Default Value String")
    private String stringValue;

    @Autowired
    private ServiceClass serviceClass;

    @Autowired
    private RepositoryClass repositoryClass;

    public void methodInJavaMain() {
        System.out.println("Printing inside method In JavaMain class");
        System.out.println(stringValue);
        serviceClass.serviceClassMethod();
        repositoryClass.repositoryClassMethod();
    }
}