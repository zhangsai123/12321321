package com.gx.test;

import org.springframework.stereotype.Component;

@Component
public class User {

    public User(){
        System.out.println("You Create A User");
    }

    public String toString(){
        return "User Object";
    }

}
