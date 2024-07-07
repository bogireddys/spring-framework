package com.bogireddy.springdemo.javaannotationbasedconfig;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "javaObjectTwo")
@Data
@Scope("prototype")
public class JavaObjectTwo implements JavaObjectInterface {


    @Override
    public void javaMethod() {
        System.out.println("Printing inside Java Object two method");
    }
}
