package com.baidan.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("读取properties文件失败");
        }
    }

    /**
     * 根据Bean的名称获取bean对象
     * @param beanname
     * @return
     */
    public static  Object getBean(String beanname) {
        Object bean = null;
        try {
            String beanPath = properties.getProperty(beanname);
            //System.out.println(beanPath);
            bean = Class.forName(beanPath).newInstance();
            //System.out.println(bean);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("获取bean失败");
        }
        return bean;
    }
}
