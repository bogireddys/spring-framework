package com.bogireddy.springdemo.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        JavaInterface javaObject = applicationContext.getBean(JavaInterface.class);
        javaObject.javaMethod();

    }
}
