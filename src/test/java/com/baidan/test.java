package com.baidan;

import com.baidan.dao.IEmployee;
import com.baidan.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class test {
    private  static  SqlSessionFactory factory;
    private  static InputStream in;

    @Before
    public void init() throws IOException {
        //1.读    factory = builder.build(in);取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

    }

    @Test
    public void testGetEmployee() throws IOException {
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IEmployee employee = session.getMapper(IEmployee.class);
        Employee employees = employee.getEmployee(3);
        System.out.println(employees.toString());
        session.close();
        in.close();
    }


    @Test
    public void findAll() throws Exception {
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IEmployee employee = session.getMapper(IEmployee.class);
        List<Employee> employees = employee.findAll();
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        session.close();
        in.close();
    }

    @Test
    public void testAddEmployee() throws Exception {
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IEmployee employee = session.getMapper(IEmployee.class);
        Employee emp = new Employee();

        // String string_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();

        String v = String.valueOf(Math.random());
        v = v.substring(v.length()-2);
        emp.setGender("男");
        emp.setJob("工程师");
        emp.setResume("ddd");
        emp.setBirthday(new Date());
        emp.setEntry_date(new Date());
        emp.setUsername("李四"+ v);
        emp.setSalary("2000");
        emp.setImgs("/adf/sdf/j.jpg");

        employee.addEmployee(emp);

        //session.insert("addEmployee", emp);

        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testAddEmployee2() throws Exception {
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IEmployee employee = session.getMapper(IEmployee.class);
        Employee emp = new Employee();

        // String string_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();

        String v = String.valueOf(Math.random());
        v = v.substring(v.length()-2);
        emp.setGender("男");
        emp.setJob("工程师");
        emp.setResume("ddd");
        emp.setBirthday(new Date());
        emp.setEntry_date(new Date());
        emp.setUsername("李四"+ v);
        emp.setSalary("2000");
        emp.setImgs("/adf/sdf/j.jpg");

        //employee.addEmployee(emp);

        session.insert("addEmployee", emp);

        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testMath() throws Exception {
        testAddEmployee2();
    }
}
