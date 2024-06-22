package com.bogireddy.springdemo.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfigMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlapplication.xml");

        XMLConfig xmlConfig = (XMLConfig) applicationContext.getBean("XMLConfig");
        xmlConfig.printInsideClass();

    }
}
