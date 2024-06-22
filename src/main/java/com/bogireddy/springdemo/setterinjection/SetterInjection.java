package com.bogireddy.springdemo.setterinjection;

public class SetterInjection {

    public int getSetterInjectionName() {
        return setterInjectionName;
    }

    public void setSetterInjectionName(int setterInjectionName) {
        this.setterInjectionName = setterInjectionName;
    }

    private int setterInjectionName;
    public SetterInjection() {
        System.out.println("Setter Injection object created");
    }

    public void printInsideClass() {
        System.out.println("Printing inside method of SetterInjection");
    }

}
