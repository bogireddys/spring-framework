package com.bogireddy.springdemo.innerbean;

public class InnerBeanDep {

    public InnerBeanDep() {
        System.out.println("Printing inside constructor of inner bean dep");
    }

    public String methodDep() {
        System.out.println("printing inside method");
        return "String in dep menthod";
    }
}
