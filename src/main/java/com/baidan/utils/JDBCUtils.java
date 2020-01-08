package com.baidan.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class JDBCUtils {

    private static DataSource dataSource;

    //加载配置文件，获取dataSource
    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 通过阿里巴巴的连接池技术获取连接
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnectionByDruid() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭资源
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }

    /**
     * 关闭资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 通过最基础的mysql驱动 获取mysql基础连接对象
     * @return Connection
     */
    public static Connection getConnectionByJDBC() {
        Connection connection = null;
        try {
            //mysql 5.0之前需要手动加载，之后不用写。
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///mydb_test", "root", "rootroot");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
