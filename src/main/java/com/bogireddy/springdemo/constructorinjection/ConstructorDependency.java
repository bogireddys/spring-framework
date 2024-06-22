package com.bogireddy.springdemo.constructorinjection;

public class ConstructorDependency {

    public ConstructorDependency() {
        System.out.println("Printing inside Dependency object of constructor injection");
    }

    public void constructorDependencyMethod() {
        System.out.println("Printing inside Dependency object of constructor injection method");
    }
}
