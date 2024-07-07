package com.bogireddy.springdemo.javaannotationbasedconfig;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "javaOne")
@Data
@Primary
public class JavaObjectOne implements JavaObjectInterface {
    @Override
    public void javaMethod() {
        System.out.println("Printing inside Java Object One method");
    }
}
