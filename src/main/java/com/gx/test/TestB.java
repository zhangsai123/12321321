package com.gx.test;


import javax.annotation.PostConstruct;

public class TestB {
    public TestB(){
        System.out.println("You Create TestB Class");
    }

    public String toString(){
        return "TestB Object";
    }

    @PostConstruct
    public void init(){
        System.out.println("执行了TestB类中的初始化方法");
    }

}
