package com.bogireddy.springdemo.innerbean;

public class InnerBean {

    public InnerBeanDep innerBeanDep;

    public InnerBeanDep getInnerBeanDep() {
        return innerBeanDep;
    }

    public void setInnerBeanDep(InnerBeanDep innerBeanDep) {
        this.innerBeanDep = innerBeanDep;
    }

    public void methodName () {
        System.out.println("Printing inside constructor of inner bean");
        System.out.println("Inner bean dep : " + innerBeanDep.methodDep());
    }
}
