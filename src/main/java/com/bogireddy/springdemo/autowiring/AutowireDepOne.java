package com.bogireddy.springdemo.autowiring;

public class AutowireDepOne implements AutowireInterface{

    public AutowireDepOne() {
        System.out.println("Printing inside AutowireDepOne");
    }

    @Override
    public void methodInsideAutowire() {
        System.out.println("Printing inside AutowireDepOne override method");
    }
}
