package com.gx.test;

import javax.annotation.PostConstruct;

/**
 * 如果把 @Component 注解从 User 类中去除,但是我们依然可以利用Spring FactoryBean接口进行创建 User 对象。
 * 参照 UserFactoryBean
 */
//@Component
public class User {

    public User(){
        System.out.println("You Create User Class");
    }

    public String toString(){
        return "User Object";
    }

    @PostConstruct
    public void UserInit(){
        System.out.println("执行了User中的初始化方法");
    }

}
