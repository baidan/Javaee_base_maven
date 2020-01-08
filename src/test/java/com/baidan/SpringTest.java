package com.baidan;

import com.baidan.controller.SpringDemo;
import com.baidan.domain.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SpringTest {
    private static ApplicationContext applicationContext;

    @Test
    public void springTest1() {
        applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        Employee es = (Employee) applicationContext.getBean("employee");
        System.out.println(es);

        Calendar calendar = Calendar.getInstance();
        // 2019-12-31
        calendar.set(2019, Calendar.DECEMBER, 31);
        Date strDate1 = calendar.getTime();
        // 2020-01-01
        calendar.set(2020, Calendar.JANUARY, 1);
        Date strDate2 = calendar.getTime();
        // 大写 YYYY
        DateFormat formatUpperCase = new SimpleDateFormat("YYYY/MM/dd");
        System.out.println("2019-12-31 to YYYY/MM/dd: " + formatUpperCase.format(strDate1));
        System.out.println("2020-01-01 to YYYY/MM/dd: " + formatUpperCase.format(strDate2));
        // 小写 YYYY
        DateFormat formatLowerCase = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("2019-12-31 to yyyy/MM/dd: " + formatLowerCase.format(strDate1));
        System.out.println("2020-01-01 to yyyy/MM/dd: " + formatLowerCase.format(strDate2));
    }

    @Test
    public void springTest2() {
        applicationContext = new AnnotationConfigApplicationContext(SpringDemo.class);
        Employee es = (Employee) applicationContext.getBean("employee");
        System.out.println(es);
    }
}
