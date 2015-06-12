package com.xu.threadLocal.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xu on 2015/6/5.
 */
public class DBUtil {
    // ���ݿ�����
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private static final String username = "root";
    private static final String password = "123456";

    //private static Connection conn = null;

    //����һ�����ڷ������ݿ����ӵľֲ�������ʹÿ���̶߳�ӵ���Լ������ӣ�
    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    public static Connection getConn(){
        Connection conn = connContainer.get();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(){
        Connection conn = connContainer.get();
        try {
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
