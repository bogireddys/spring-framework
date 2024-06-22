package com.bogireddy.springdemo.lazyinitilization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyInitializationMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("lazyinitialization.xml");
        // If you un comment below line you will get constructor output
//        applicationContext.getBean(LazyInitialization.class);
    }
}
