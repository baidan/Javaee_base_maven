package com.baidan.controller;

import com.baidan.domain.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/spring-demo/*") // /user/add /user/find
@Configuration  //spring注解方式  配置类===配置文件
public class SpringDemo extends BaseServlet {

        /**
         * 给容器中注册一个bean，类型为返回值的类型
         * @return
         */
        @Bean
        public Employee employee(){
                return  new Employee("王小琼", new Date(),"女");
        }


        public  void  springdemo1(HttpServletRequest res, HttpServletResponse rep){

        }
}
