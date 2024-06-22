package com.bogireddy.springdemo.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InnerBeanMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("innerbean.xml");
        InnerBean innerBean = applicationContext.getBean(InnerBean.class);
        innerBean.methodName();
    }
}
