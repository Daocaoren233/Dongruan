package com.homework.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCutils {

//    private static DataSource ds;
//
//    static {
//        Properties pro = new Properties();
//        InputStream in = JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties");
//        try {
//            pro.load(in);
//            ds = DruidDataSourceFactory.createDataSource(pro);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConnection() throws SQLException {
//
//        return ds.getConnection();
//    }
//
//    public static void close(Statement stmt,Connection conn){
//        close(null,stmt,conn);
//
//    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private static DataSource ds;

    static {
        Properties pro = new Properties();
        InputStream in = JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(in);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
