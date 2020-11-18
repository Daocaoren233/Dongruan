package com.homework;

import java.sql.*;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//
//        Connection conn = DriverManager.getConnection("jdbc:mysql://"+
//                "localhost:3306/dongruan","root","root");
//
//        Statement stmt = conn.createStatement();
//
//        String sql = "update account set grade = 85 where id = 1";
//
//        int i = stmt.executeUpdate(sql);
//
//        if(i == 1){
//            System.out.println("更新成功！");
//        }
//        else{
//            System.out.println("更新失败！");
//        }
//        stmt.close();
//        conn.close();
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dongruan","root","root");

        Statement stmt = conn.createStatement();

        String sql = "update infor set balance = 150 where id = 1";

        int i = stmt.executeUpdate(sql);

        if(i == 1){
            System.out.println("更新成功！");
        }
        else{
            System.out.println("更新失败！");
        }
        stmt.close();
        conn.close();


    }
}
