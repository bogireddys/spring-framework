package com.bogireddy.springdemo.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {

    @Bean(name = {"javaInterface", "javaBeanName"})
    @Scope("prototype")
    public JavaInterface javaInterface(@Autowired JavaAutowireObject javaAutowireObject) {
        JavaObject javaObject = new JavaObject();
        javaObject.setJavaAutowireObject(javaAutowireObject);
        return javaObject;
    }

    @Bean(name = {"javaAutowired"})
//    @Scope("prototype")
    public JavaAutowireObject javaAutowireObject() {
        return new JavaAutowireObject();
    }


}
