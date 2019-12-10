package com.baidan.controller;


import com.baidan.dao.IEmployee;
import com.baidan.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


@WebServlet("/mybatis/*") // /user/add /user/find
public class MybatisServlet extends BaseServlet {
    private  static InputStream in;
    private  static  SqlSessionFactory factory;
    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void mybatis1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了mybatis1方法");
    }


    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * 遇到了项目结构导致的问题
     */
    public  void  mybatis2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了mybatis2方法");
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IEmployee employee = session.getMapper(IEmployee.class);
        List<Employee> employees = employee.findAll();
        for(Employee emp : employees){
            System.out.println(emp);
        }
        session.close();;
        in.close();

    }

    public  void  mybatis3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        //IEmployee employee = session.getMapper(IEmployee.class);
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

}
