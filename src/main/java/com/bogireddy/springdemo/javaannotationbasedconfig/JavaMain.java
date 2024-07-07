package com.bogireddy.springdemo.javaannotationbasedconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaAppConfig.class);
        JavaMainObject javaMainObject = applicationContext.getBean(JavaMainObject.class);
        javaMainObject.javaMainMethod();



    }
}
