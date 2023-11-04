package fit.example.login5.utils;

import java.sql.*;

//理解为什么写成通用封装类
public class DBConn {
    public static Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/javaweb_schema?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String pwd = "123456";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.getMessage();
        }
        return conn;
    }
}
