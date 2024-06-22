package com.bogireddy.springdemo.autowiring;

public class AutowireDepTwo implements AutowireInterface {

    public AutowireDepTwo() {
        System.out.println("Printing inside AutowireDepTwo");
    }

    @Override
    public void methodInsideAutowire() {
        System.out.println("Printing inside AutowireDepTwo override method");
    }
}
