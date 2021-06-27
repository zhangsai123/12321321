package com.gx.test;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("TestA")
public class TestA {

    public TestA(){
        System.out.println("You Create TestA Class");
    }

    public String toString(){
        return "TestA Object";
    }

    @PostConstruct
    public void init(){
        System.out.println("执行了TestA类中的初始化方法");
    }
}
