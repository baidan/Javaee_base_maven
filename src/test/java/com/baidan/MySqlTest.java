package com.baidan;

import com.baidan.utils.GlobalVar;
import com.baidan.utils.JDBCUtils;
import org.junit.Test;

import java.sql.*;

public class MySqlTest {
    @Test
    public void test1() throws SQLException {
        //1,注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        //2,获取连接
        Connection connection = DriverManager.getConnection(GlobalVar.JDBC_URL, GlobalVar.JDBC_USER, GlobalVar.JDBC_PASSWORD);

        //3,获取操作数据库的预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");

        //4,执行SQL,得到结果
        ResultSet rs = preparedStatement.executeQuery();

        //5,遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("username"));
        }
        //6,释放资源
        rs.close();
        preparedStatement.close();
        connection.close();
    }

    public void test2(){
        Connection connectionByJDBC = JDBCUtils.getConnectionByJDBC();

    }
}
