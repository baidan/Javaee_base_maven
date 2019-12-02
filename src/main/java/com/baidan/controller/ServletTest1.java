package com.baidan.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/servletTest1")
public class ServletTest1 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletTest1");
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        boolean f = true;
        if(cookies != null && cookies.length >0)
        for (Cookie s : cookies){
                String name = s.getName();
                if("lastTime" .equals(name)){
                    String value = s.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    resp.getWriter().write("<div>欢迎回来，您上次访问时间为:</div>"+value);
                    setCookie(req, resp);
                    break;
                }else{
                    f = false;
                }
        }

        if(cookies == null || cookies.length == 0 || f == false){
            setCookie(req, resp);
            resp.getWriter().write("<div>您好，欢迎您首次访问！</div>");
        }

        HttpSession session = req.getSession();//只要产生了session对象，那么客户端就会产生cookie：JSESSIONID
        session.setAttribute("msg", "Hellen");
    }

    public static  void  setCookie(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = simpleDateFormat.format(date);

        str_date = URLEncoder.encode(str_date, "utf-8");

        Cookie lastTime = new Cookie("lastTime", str_date);
        lastTime.setMaxAge(60 * 60 * 24 * 30);
        res.addCookie(lastTime);
    }
}
