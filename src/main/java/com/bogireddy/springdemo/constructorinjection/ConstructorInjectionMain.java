package com.bogireddy.springdemo.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("constructorinjection.xml");
        ConstructorInjection constructorInjection = (ConstructorInjection) applicationContext.getBean("ConstructorInjection");

    }
}
