package com.bogireddy.springdemo.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(MainClass.class, args);
        JavaMain javaMain = applicationContext.getBean(JavaMain.class);
        javaMain.methodInJavaMain();

    }
}

