package com.gx.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    public Object postProcessBeforeInitialization(Object bean, String beanName){
        /**
         * postProcessBeforeInitialization 初始化之前增强的方法
         */

        if (beanName.equals("TestA"))
            System.out.println("postProcessBeforeInitialization 初始化之前增强的方法" + beanName);
        return bean;
    }

   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       /**
        * postProcessAfterInitialization 初始化之后的增强方法
        */
       if (beanName.equals("TestA"))
            System.out.println("postProcessAfterInitialization 初始化之后的增强方法" +  beanName);
       return bean;
    }


}
