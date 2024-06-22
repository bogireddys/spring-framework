package com.bogireddy.springdemo.autowiring;

public class Autowiring {

    private String value;
    private AutowireDepOne autowireDepOne;
    private AutowireDepOne autowireDepTwo;

    public Autowiring(String value, AutowireInterface autowireInterface) {
        System.out.println("Printing inside Autowire class");
        System.out.println("Value is :" + value);
    }
}
