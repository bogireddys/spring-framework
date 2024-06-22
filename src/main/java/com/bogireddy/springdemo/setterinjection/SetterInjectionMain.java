package com.bogireddy.springdemo.setterinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("setterinjection.xml");

        SetterInjection setterInjection = (SetterInjection) applicationContext.getBean("SetterInjection");
        setterInjection.printInsideClass();
        System.out.println("Value is : " + setterInjection.getSetterInjectionName());

    }
}
