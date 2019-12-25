package com.baidan;

import com.baidan.controller.SpringDemo;
import com.baidan.domain.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    private  static ApplicationContext applicationContext;

    @Test
    public void springTest1(){
        applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        Employee es = (Employee) applicationContext.getBean("employee");
        System.out.println(es);
    }

    @Test
    public void springTest2(){
        applicationContext = new AnnotationConfigApplicationContext(SpringDemo.class);
        Employee es = (Employee) applicationContext.getBean("employee");
        System.out.println(es);
    }
}
