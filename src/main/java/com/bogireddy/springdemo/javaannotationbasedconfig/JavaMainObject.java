package com.bogireddy.springdemo.javaannotationbasedconfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
public class JavaMainObject {

    @Autowired
    @Qualifier("javaObjectTwo")
    private JavaObjectInterface javaObjectInterface;

    @Value("DefaultValue")
    private String stringObj;

    public void javaMainMethod() {
        System.out.println("Printing inside Java Object main method");
        javaObjectInterface.javaMethod();
        System.out.println("String obj value : "+stringObj);
    }

}
