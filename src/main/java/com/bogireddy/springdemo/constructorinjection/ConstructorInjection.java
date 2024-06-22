package com.bogireddy.springdemo.constructorinjection;

public class ConstructorInjection {
    private int value;
    private ConstructorDependency constructorDependency;

    public ConstructorInjection(int value) {
        this.value = value;
        System.out.println("Printing inside constructor of ConstructorInjection");
        System.out.println("Value is : " + value);
    }

    public ConstructorInjection(int value, ConstructorDependency constructorDependency) {
        System.out.println("Printing inside object constructor of ConstructorInjection");
        System.out.println("Value is : " + value);
        constructorDependency.constructorDependencyMethod();
    }

}
