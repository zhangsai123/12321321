package com.gx.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 *  我们可以利用 Spring 所提供的 FactoryBean 接口去自定义我们要创建哪些类对象放入 Spring 的容器中去进行管理
 *  在此处我们可以自定义自己创建对象时的逻辑，一般在复杂创建复杂对象时可以使用此种方式。
 */
@Component
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        /**
         * 返回一个User对象，Spring会将返回的容器放入Spring的容器中进行管理
         */
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
