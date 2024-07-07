package com.bogireddy.springdemo.javaconfig;

import lombok.Data;

@Data
public class JavaObject implements JavaInterface {

    private String stringData;

//    @Autowired
    private JavaAutowireObject javaAutowireObject;

    @Override
    public void javaMethod() {
        System.out.println("Printing inside Java method");
        javaAutowireObject.javaAutowiredMethod();
    }
}
