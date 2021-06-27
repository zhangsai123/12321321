package com.gx.test;

import com.gx.config.Generator.model.Hr;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author : Zhangsai
 * @Date : 2020/08/16/0:50
 * @Description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/springMvc.xml","classpath:spring/redisConfig.xml"})
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class TestClass {
    @Test
    public void DataSourceTest(){
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        SqlSessionFactory SqlSessionFactory = (org.apache.ibatis.session.SqlSessionFactory) ApplicationContext.getBean("sqlSessionFactory");
        System.out.println(SqlSessionFactory);
    }


    @Test
    public void GetBeanMethod(){
        /**
         * 使用classpath路径
         */
        // ClassPathXmlApplicationContext使用了file前缀是可以使用绝对路径的
        // ApplicationContext factory = new ClassPathXmlApplicationContext("file:F:/workspace/example/src/appcontext.xml");
        //ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        SqlSessionFactory SqlSessionFactory = (org.apache.ibatis.session.SqlSessionFactory) ApplicationContext.getBean("sqlSessionFactory");
        System.out.println(SqlSessionFactory);


        // 用文件系统的路径,默认指项目的根路径
        // ApplicationContext factory = new FileSystemXmlApplicationContext("src/appcontext.xml");
        // ApplicationContext factory = new FileSystemXmlApplicationContext("webRoot/WEB-INF/appcontext.xml");


        // 使用了classpath:前缀,这样,FileSystemXmlApplicationContext也能够读取classpath下的相对路径
        // ApplicationContext factory = new FileSystemXmlApplicationContext("classpath:appcontext.xml");
        // ApplicationContext factory = new FileSystemXmlApplicationContext("file:F:/workspace/example/src/appcontext.xml");

        // 不加file前缀
        //ApplicationContext factory = new FileSystemXmlApplicationContext("F:/workspace/example/src/appcontext.xml");
        //IHelloWorld hw = (IHelloWorld)factory.getBean("helloworldbean");
        //log.info(hw.getContent("luoshifei"));

    }

    /**
     * 通过注解的xml方式获取Bean
     */
    @Test
    public void GetBeanMethodByXmlMethod(){
        /**
         * 将要放入Spring容器的Bean配置在xml文件中,通过xml文件的形式向IOC容器中注入配置Bean
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/beanConfig.xml");
        Hr hr = (Hr) context.getBean("Hr");
        System.out.println(hr);
    }


    /**
     * 通过注解的方式获取Bean
     */
    @Test
    public  void GetBeanByAnnotationMethod(){
        /**
         * TestConfig中使用了@ComponentScan扫描注解，其作用相当于<context:component-scan>
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        /**
         * 如果将User类上的@Component注解去除，Spring无法将User类的对象放入IOC中，执行 context.getBean(User.class) 会报错
         * 这时我们可以用一个 UserFactoryBean 实现 FactoryBean 接口来创建User类对象，并将其放入Spirng IOC容器中去
         */
        System.out.println(context.getBean(User.class));
    }


    @Test
    public void BeanFactoryProcessorTestMethod(){

        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        /**
         * 虽然TestB类上并没有加入任何Spring注解，但是通过实现 BeanFactoryPostProcessor 接口的形式，
         * 在 postProcessBeanFactory 方法中，将 @Component("TestA") 所对应的 TestA 类修改成了 TestB 类，
         * 这效果也就相当于在 TestB 类上加了了一个 @Component("TestA") 的注解一样
         * 参考 MyBeanFactoryProcessor
         */
        System.out.println(context.getBean(TestB.class));
    }



}
