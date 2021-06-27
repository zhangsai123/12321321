package com.gx.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("执行了 postProcessBeanFactory 方法");

        /**
         *  getBeanDefinition("TestA")方法中的TestA，并不是类名而是注入到Spring容器中的Bean的名字
         */
        AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("TestA");

        /**
         * 这里是将Bean名字是TestA的所对应的类对象，修改为TestB类的对象
         */
        beanDefinition.setBeanClass(TestB.class);

    }
}
